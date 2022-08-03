package bragagustavo.com.github.api.service;

import bragagustavo.com.github.api.domain.entity.Order;
import bragagustavo.com.github.api.domain.entity.OrderItem;
import bragagustavo.com.github.api.exception.ObjectNotFoundException;
import bragagustavo.com.github.api.repository.ClientRepository;
import bragagustavo.com.github.api.repository.OrderItemRepository;
import bragagustavo.com.github.api.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientRepository c;
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

        for (OrderItem oi : order.getItens()) {
            oi.setProduct(productService.find(oi.getProduct().getId()));
            oi.setPrice(oi.getProduct().getPrice());
            oi.generateSubTot();
            oi.setOrder(order);
        }

        orderItemRepository.saveAll(order.getItens());
        return order;

    }

    public Order findById(Integer id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + id +
                "tipo: " + Order.class.getName()));
    }

    public Page<Order> findPage(Integer page, Integer linesPerPage, String orderBy, String direction, Integer id) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        return orderRepository.findByClient(c.findById(id), pageRequest);


    }
}
