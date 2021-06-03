package com.ecommerce.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * The type Product.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product name is required.")
    @Basic(optional = false)
    private String name;

    @NotNull(message = "Product price is required.")
    private Double price;

    private String pictureUrl;

    /**
     * Instantiates a new Product.
     *
     * @param id         the id
     * @param name       the name
     * @param price      the price
     * @param pictureUrl the picture url
     */
    public Product(Long id, @NotNull(message = "Product name is required.") String name, Double price, String pictureUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pictureUrl = pictureUrl;
    }
}
