package com.ecommerce.repository;

import com.ecommerce.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * The interface Customer payment repos.
 */
public interface PaymentRepos extends JpaRepository<PaymentEntity, Long> {

}
