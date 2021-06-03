package com.ecommerce.repository;

import com.ecommerce.entities.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Order repository.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
}
