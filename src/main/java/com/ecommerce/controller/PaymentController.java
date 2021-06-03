package com.ecommerce.controller;

import com.ecommerce.model.PaymentRequest;
import com.ecommerce.model.PaymentResponse;
import com.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Payment controller.
 */
@RestController
@RequestMapping("/api/payment")
public class PaymentController {


    /**
     * The Payment service.
     */
    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * Payment customer payment response.
     *
     * @param paymentRequest the customer payment request
     * @return the customer payment response
     */
    @PostMapping
    PaymentResponse payment(@RequestBody PaymentRequest paymentRequest){
        PaymentResponse paymentResponse = paymentService.payment(paymentRequest);
        return paymentResponse;
    }
}
