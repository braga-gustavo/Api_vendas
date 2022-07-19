package bragagustavo.com.github.api.controller.api;

import bragagustavo.com.github.api.domain.entity.Product;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface ProductAPI {

    public ResponseEntity<Void> insertProduct(@RequestBody @Valid Product product);
}
