package bragagustavo.com.github.api.controller;

import bragagustavo.com.github.api.controller.api.ProductAPI;
import bragagustavo.com.github.api.domain.dto.ProductDto;
import bragagustavo.com.github.api.domain.entity.Product;
import bragagustavo.com.github.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController implements ProductAPI {

    @Autowired
    private ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertProduct(@RequestBody @Valid Product product) {
        productService.insertProduct(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> findProduct(@PathVariable Integer id) {
        Product product = productService.find(id);
        return ResponseEntity.ok().body(product);

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = productService.findAll();
        return ResponseEntity.ok().body(list);

    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateProduct(@PathVariable Integer id, @Valid @RequestBody ProductDto productDto) {
        Product product = productService.fromDto(productDto);
        product.setId(id);
        productService.updateProduct(product);
        return ResponseEntity.noContent().build();

    }



    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();

    }
}


