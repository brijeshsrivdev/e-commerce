package com.ecommerce.service;


import com.ecommerce.entities.Order;
import com.ecommerce.model.PaymentRequest;
import com.ecommerce.model.PaymentResponse;

/**
 * The interface Customer payment service.
 */
public interface PaymentService {

    /**
     * Payment customer payment response.
     *
     * @param paymentRequest the customer payment request
     * @return the customer payment response
     */
    PaymentResponse payment(PaymentRequest paymentRequest);
    Long initiatePayment(Order orderId);
}
