package com.ecommerce.repository;

import com.ecommerce.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Product repository.
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
    /**
     * Find by name in list.
     *
     * @param listNames the list names
     * @return the list
     */
    List<Product> findByNameIn(Iterable<String> listNames);
}
