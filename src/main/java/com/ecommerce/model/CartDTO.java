package com.ecommerce.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Cart dto.
 */
@Getter
@Setter
@ToString
public class CartDTO {
    private Long productId;
    private Integer stock;
    private String status;
    private Long userId;

}
