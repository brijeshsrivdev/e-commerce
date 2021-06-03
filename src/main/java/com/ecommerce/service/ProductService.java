package com.ecommerce.service;

import com.ecommerce.entities.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * The interface Product service.
 */
@Validated
public interface ProductService {
    /**
     * Gets all products.
     *
     * @return the all products
     */
    @NotNull Iterable<Product> getAllProducts();

    /**
     * Gets product.
     *
     * @param id the id
     * @return the product
     */
    Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    /**
     * Save product.
     *
     * @param product the product
     * @return the product
     */
    Product save(Product product);

    /**
     * Save all list.
     *
     * @param products the products
     * @return the list
     */
    List<Product> saveALL(List<Product> products);
}
