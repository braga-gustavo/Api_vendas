package bragagustavo.com.github.api.controller;

import bragagustavo.com.github.api.domain.entity.Order;
import bragagustavo.com.github.api.service.OrderService;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<Void> includeOrder(@RequestBody @Valid Order order) {
        order = orderService.includeOrder(order);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).build();


    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Order> find(@PathVariable Integer id) {
        Order order = orderService.findById(id);
        return ResponseEntity.ok().body(order);

    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<Order>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerpage,
            @RequestParam(value = "orderBy", defaultValue = "instante") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction,
            @RequestBody Integer id
    ) {
        Page<Order> list = orderService.findPage(page, linesPerpage, orderBy, direction, id);
        return ResponseEntity.ok().body(list);
    }
}
