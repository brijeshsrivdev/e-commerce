package com.ecommerce.controller;

import com.ecommerce.entities.Product;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.service.ProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The type Product controller.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;

    /**
     * Instantiates a new Product controller.
     *
     * @param productService the product service
     */
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    /**
     * Gets products.
     *
     * @return the products
     */
    @GetMapping(value = { "", "/" })
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }

    /**
     * Create products.
     *
     * @param productForm the product form
     */
    @PostMapping(value = "/create")
    public void createProducts(@RequestBody ProductForm productForm){
        List<Product> products = productForm.getProducts();
        validateProducts(products);
        productService.saveALL(products);
    }

    /**
     * The type Product form.
     */
    @Getter
    @Setter
    public static class ProductForm {
        private List<Product> products;
    }


    /**
     * The interface Product validation.
     */
    interface ProductValidation extends Function<Product, Boolean> {
        /**
         * Name is not empty product validation.
         *
         * @return the product validation
         */
        static ProductValidation nameIsNotEmpty() {
            return product -> !product.getName().trim().isEmpty();
        }

        /**
         * Price check product validation.
         *
         * @return the product validation
         */
        static ProductValidation priceCheck() {
            return product -> product.getPrice() != null && product.getPrice() != 0 && product.getPrice() > 0;
        }

        /**
         * And product validation.
         *
         * @param productValidation the product validation
         * @return the product validation
         */
        default ProductValidation and(ProductValidation productValidation) {
            return product -> this.apply(product) && productValidation.apply(product);
        }
    }

    private void validateProducts(List<Product> products) {

        StringBuffer validationMessage = new StringBuffer();
        List<Product> validatedProductList = products
                .stream()
                .filter(product->{
                    if(!ProductValidation.nameIsNotEmpty().apply(product)){
                        validationMessage.append(" (Product is empty with name "+product.getId()+") ");
                        return  true;
                    }
                    if(!ProductValidation.priceCheck().apply(product)){
                        validationMessage.append(" (Product is empty with price for "+product.getId()+") ");
                        return  true;
                    }
                   return false;
                })
                .collect(Collectors.toList());

        if (validationMessage.length()>0) {
            throw new ResourceNotFoundException(validationMessage.toString());
        }

        if (!CollectionUtils.isEmpty(validatedProductList)) {
            throw new ResourceNotFoundException(validationMessage.toString());
        }
    }
}
