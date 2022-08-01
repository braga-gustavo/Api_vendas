package bragagustavo.com.github.api.repository;

import bragagustavo.com.github.api.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
