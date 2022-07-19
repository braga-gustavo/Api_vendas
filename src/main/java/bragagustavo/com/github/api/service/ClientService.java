package bragagustavo.com.github.api.service;

import bragagustavo.com.github.api.domain.dto.ClientDto;
import bragagustavo.com.github.api.domain.entity.Client;
import bragagustavo.com.github.api.exception.ObjectNotFoundException;
import bragagustavo.com.github.api.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client insertClient(Client client) {
        client.setId(null);
        return clientRepository.save(client);
    }

    public Client updateClient(Client client) {
        Client clientToUpdate = find(client.getId());
        updateData(clientToUpdate, client);
        return clientRepository.save(clientToUpdate);
    }

    public void updateData(Client clientToUpdate, Client client) {
        clientToUpdate.setName(client.getName());
        clientToUpdate.setEmail(client.getEmail());
        clientToUpdate.setPhone(client.getName());

    }

    public Client find(Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado: " + id + ", tipo:" +
                Client.class.getName()));

    }

    public Client fromDto(ClientDto clientDto) {

        return new Client(clientDto.getId(), clientDto.getName(), clientDto.getEmail(), clientDto.getPhone(),
                null);
    }

    public void deleteClient(Integer id) {

        find(id);

        try {

            clientRepository.deleteById(id);

        } catch (DataIntegrityViolationException e ) {
            throw new DataIntegrityViolationException("Não foi possível excluir cliente com dados vinculados.");

        }
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }
}
