package com.ecommerce.entities;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * The type Customer payment entity.
 */
@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="payment_id")
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name="created_timestamp")
    private LocalDateTime createdTimestamp;

    @Column(name = "payment_mode")
    private String paymentMode;

    @Column(name = "order_amount")
    private Double orderAmount;

    @Column(name = "tx_status")
    private String txStatus;
}
