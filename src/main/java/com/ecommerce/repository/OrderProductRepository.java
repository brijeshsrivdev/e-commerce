package com.ecommerce.repository;

import com.ecommerce.entities.OrderProduct;
import com.ecommerce.entities.OrderProductPK;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Order product repository.
 */
public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}
