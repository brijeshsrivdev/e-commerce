package com.ecommerce.model;

import lombok.*;


/**
 * The type Customer payment request.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentRequest {
    private Long initialPaymentRef;
    private String paymentMode;
    private Double orderAmount;
    private Long orderId;
    private String txTime;
}
