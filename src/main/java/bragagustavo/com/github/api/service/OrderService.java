package bragagustavo.com.github.api.service;

import bragagustavo.com.github.api.domain.entity.Order;
import bragagustavo.com.github.api.domain.entity.OrderItem;
import bragagustavo.com.github.api.repository.OrderItemRepository;
import bragagustavo.com.github.api.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class OrderService {
    @Autowired
    private ClientService clientService;

    @Autowired
    private OrderItemRepository orderItemRepository;

    //Autowirde "manual"
    private final OrderRepository orderRepository;

    @Autowired
    private ProductService productService;


    public Order includeOrder(Order order) {
        order.setId(null);
        order.setInstant(new Date());
        order.setClient(clientService.find(order.getClient().getId()));
        order = orderRepository.save(order);


        for (OrderItem oi: order.getItens()){
            oi.setProduct(productService.find(oi.getProduct().getId()));
            oi.setPrice(oi.getProduct().getPrice());
            oi.generateSubTot();
            oi.setOrder(order);
        }


        orderItemRepository.saveAll(order.getItens());
        return order;

    }


}
