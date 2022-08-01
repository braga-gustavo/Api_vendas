package bragagustavo.com.github.api.domain.entity;

import bragagustavo.com.github.api.domain.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date instant;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> itens = new HashSet<>();


    public Order(Integer id, Client client, Set<OrderItem> itens) {
        this.id = id;
        this.client = client;
        this.itens = itens;
    }

    public Order(Integer id, Set<OrderItem> itens) {
        this.id = id;
        this.itens = itens;
    }
}
