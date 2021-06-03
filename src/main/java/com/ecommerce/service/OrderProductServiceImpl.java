package com.ecommerce.service;

import com.ecommerce.entities.OrderProduct;
import com.ecommerce.repository.OrderProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The type Order product service.
 */
@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService {
    private OrderProductRepository orderProductRepository;

    /**
     * Instantiates a new Order product service.
     *
     * @param orderProductRepository the order product repository
     */
    public OrderProductServiceImpl(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }
}
