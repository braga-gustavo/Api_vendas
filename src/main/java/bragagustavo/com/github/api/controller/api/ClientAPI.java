package bragagustavo.com.github.api.controller.api;

import bragagustavo.com.github.api.domain.entity.Client;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface ClientAPI {

     public ResponseEntity<Void> insertClient(@RequestBody @Valid Client client);
    //  public ResponseEntity<Void> updateClient();
    // public ResponseEntity<Void> findClient();
   //  public ResponseEntity<Void> deleteClient();

}
