package bragagustavo.com.github.api.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.text.NumberFormat;
import java.util.Locale;

@Entity
public class OrderItem {
    @JsonIgnore
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;

    private Double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        this.id.setOrder(order);
        this.id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public void generateSubTot(){
        price = price * quantity;
    }

    public double getSubTotal(){
        return price * quantity;
    }

    @JsonIgnore
    public Order getOrder(){
        return this.id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Product getProduct(){
        return this.id.getProduct();
    }

    public OrderItemPK getId() {
        return id;
    }

    public void setId(OrderItemPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        final StringBuffer sb = new StringBuffer();
        sb.append(getProduct().getTitle())
                .append(", Qte: " + getQuantity())
                .append(", PreÃ§o Unitario: " + nf.format(getPrice()))
                .append(" subTotal: " + nf.format(getSubTotal()))
                .append("\n");
        return sb.toString();
    }
}


