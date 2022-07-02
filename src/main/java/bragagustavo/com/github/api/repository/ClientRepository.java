package bragagustavo.com.github.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import bragagustavo.com.github.api.domain.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
