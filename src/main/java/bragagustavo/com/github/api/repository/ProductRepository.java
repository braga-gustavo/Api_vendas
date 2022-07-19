package bragagustavo.com.github.api.repository;

import bragagustavo.com.github.api.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
