package bragagustavo.com.github.api.repository;

import bragagustavo.com.github.api.domain.entity.Client;
import bragagustavo.com.github.api.domain.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    //@Query("select p from Pedido p left join fetch p.itens where p.id = :id") Query inutilizada
    //Optional<Order> findByIdFetchItens(@Param("id") Integer id);

    @Transactional
    Page<Order> findByClient(Optional<Client> client, Pageable pageRequest);
}
