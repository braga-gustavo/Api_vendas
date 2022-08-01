package bragagustavo.com.github.api.controller;

import bragagustavo.com.github.api.domain.entity.Order;
import bragagustavo.com.github.api.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/pedido")
public class OrderController {

    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> includeOrder(@RequestBody @Valid Order order){
         order =  orderService.includeOrder(order);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).build();


    }

}
