package com.ecommerce.service;

import com.ecommerce.entities.OrderProduct;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * The interface Order product service.
 */
@Validated
public interface OrderProductService {
    /**
     * Create order product.
     *
     * @param orderProduct the order product
     * @return the order product
     */
    OrderProduct create(@NotNull(message = "The products for order cannot be null.") @Valid OrderProduct orderProduct);
}
