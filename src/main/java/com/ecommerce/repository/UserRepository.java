package com.ecommerce.repository;

import com.ecommerce.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface User repository.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
