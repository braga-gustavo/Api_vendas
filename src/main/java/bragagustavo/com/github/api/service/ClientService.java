package bragagustavo.com.github.api.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bragagustavo.com.github.api.domain.entity.Client;
import bragagustavo.com.github.api.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client insertclient(Client client){
        client.setId(null);
        return clientRepository.save(client);
    }
    
}
