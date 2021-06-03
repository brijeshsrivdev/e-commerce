package com.ecommerce.service;


import com.ecommerce.entities.Order;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * The interface Order service.
 */
@Validated
public interface OrderService {
    /**
     * Gets all orders.
     *
     * @return the all orders
     */
    @NotNull Iterable<Order> getAllOrders();

    /**
     * Create order.
     *
     * @param order the order
     * @return the order
     */
    Order create(@NotNull(message = "The order cannot be null.") @Valid Order order);

    /**
     * Update.
     *
     * @param order the order
     */
    void update(@NotNull(message = "The order cannot be null.") @Valid Order order);
}
