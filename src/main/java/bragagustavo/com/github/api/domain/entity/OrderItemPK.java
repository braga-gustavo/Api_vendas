package bragagustavo.com.github.api.domain.entity;

import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;

@Data
public class OrderItemPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
