package bragagustavo.com.github.api.repository;

import bragagustavo.com.github.api.domain.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
