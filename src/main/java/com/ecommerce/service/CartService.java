package com.ecommerce.service;

import com.ecommerce.entities.Cart;
import com.ecommerce.model.CartDTO;

import java.util.List;

/**
 * The interface Cart service.
 */
public interface CartService {
    /**
     * Save products cart.
     *
     * @param cartDTO the cart dto
     * @return the cart
     */
    Cart saveProducts(CartDTO cartDTO);

    /**
     * Find all list.
     *
     * @param userId the user id
     * @return the list
     */
    List<Cart> findAll(Long userId);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Cart> findAll();

    /**
     * Update product cart.
     *
     * @param cartDTO the cart dto
     * @param id      the id
     * @return the cart
     */
    Cart updateProduct(CartDTO cartDTO, Long id);

    /**
     * Delete product.
     *
     * @param id the id
     */
    void deleteProduct(Long id);

    /**
     * Clear shopping cart.
     *
     * @param object the object
     */
    void clearShoppingCart(Object object);

    /**
     * Find by purchased list.
     *
     * @return the list
     */
    List<Cart> findByPurchased();

    /**
     * Purchase products.
     *
     * @param id the id
     */
    void purchaseProducts(Long id);
}
