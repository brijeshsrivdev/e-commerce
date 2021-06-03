package com.ecommerce.service;

import com.ecommerce.entities.Order;
import com.ecommerce.exception.ApiExceptionHandler;
import com.ecommerce.exception.NotFoundException;
import com.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * The type Order service.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {


    private OrderRepository orderRepository;
    private PaymentService paymentService;

    /**
     * Instantiates a new Order service.
     *
     * @param orderRepository the order repository
     */
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, PaymentService paymentService) {
        this.orderRepository = orderRepository;
        this.paymentService = paymentService;
    }

    @Override
    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Order create(Order order) {
        order.setDateCreated(LocalDate.now());
        Order orderCreated = this.orderRepository.save(order);
        if(orderCreated == null) {
            throw new NotFoundException("Exception occured while creating order");
        }
        order.setInitialPaymentRef(paymentService.initiatePayment(orderCreated));
        return orderCreated;
    }

    @Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }
}