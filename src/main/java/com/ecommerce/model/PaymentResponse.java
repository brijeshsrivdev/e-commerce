package com.ecommerce.model;


import lombok.*;

import java.time.LocalDateTime;

/**
 * The type Customer payment response.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentResponse {
    /**
     * The Payment response message.
     */
    String msg;

}
