package com.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Objects;

/**
 * The type Order product.
 */
@Entity
@Getter
@Setter
public class OrderProduct {
    @EmbeddedId
    @JsonIgnore
    private OrderProductPK pk;

    @Column(nullable = false) private Integer quantity;

    /**
     * Instantiates a new Order product.
     */
    public OrderProduct() {
        super();
    }

    /**
     * Instantiates a new Order product.
     *
     * @param order    the order
     * @param product  the product
     * @param quantity the quantity
     */
    public OrderProduct(Order order, Product product, Integer quantity) {
        pk = new OrderProductPK();
        pk.setOrder(order);
        pk.setProduct(product);
        this.quantity = quantity;
    }

    /**
     * Gets product.
     *
     * @return the product
     */
    @Transient
    public Product getProduct() {
        return this.pk.getProduct();
    }

    /**
     * Gets total price.
     *
     * @return the total price
     */
    @Transient
    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderProduct that = (OrderProduct) o;

        if (!Objects.equals(pk, that.pk)) return false;
        return Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        int result = pk != null ? pk.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
