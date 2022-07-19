package bragagustavo.com.github.api.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import bragagustavo.com.github.api.controller.api.ClientAPI;
import bragagustavo.com.github.api.domain.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import bragagustavo.com.github.api.domain.entity.Client;
import bragagustavo.com.github.api.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController implements ClientAPI {

    @Autowired
    private ClientService clientService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertClient(@RequestBody @Valid Client client) {
        clientService.insertClient(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateClient(@PathVariable Integer id, @Valid @RequestBody ClientDto clientDto){
      Client client = clientService.fromDto(clientDto);
      client.setId(id);
      clientService.updateClient(client);
      return ResponseEntity.noContent().build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Client> findClient(@PathVariable Integer id){
        Client client = clientService.find(id);
        return  ResponseEntity.ok().body(client);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteClient(@PathVariable Integer id){
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Client>> findAll(){
        List<Client> list = clientService.findAll();
        return ResponseEntity.ok().body(list);

    }
}