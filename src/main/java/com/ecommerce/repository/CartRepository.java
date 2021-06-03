package com.ecommerce.repository;

import com.ecommerce.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Cart repository.
 */
public interface CartRepository extends JpaRepository<Cart, Long> {
    /**
     * Find by status list.
     *
     * @param status the status
     * @return the list
     */
    List<Cart> findByStatus(String status);

    /**
     * Find by status and id list.
     *
     * @param not_purchased the not purchased
     * @param userId        the user id
     * @return the list
     */
    List<Cart> findByStatusAndId(String not_purchased, Long userId);
}
