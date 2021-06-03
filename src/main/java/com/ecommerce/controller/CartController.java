package com.ecommerce.controller;

import com.ecommerce.entities.Cart;
import com.ecommerce.model.CartDTO;
import com.ecommerce.service.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Cart controller.
 */
@RestController
@RequestMapping("/api/cart")
public class CartController {

    private CartServiceImpl cartServiceImpl;

    @Autowired
    public CartController(CartServiceImpl cartServiceImpl) {
        this.cartServiceImpl = cartServiceImpl;
    }

    /**
     * Add product item cart.
     *
     * @param shoppingCartDTO the shopping cart dto
     * @return the cart
     */
    @PostMapping
    public Cart addProductItem(@RequestBody CartDTO shoppingCartDTO) {
        return cartServiceImpl.saveProducts(shoppingCartDTO);
    }


    /**
     * Get all list.
     *
     * @return the list
     */
    @GetMapping
    public List<Cart> getAll(){
        return cartServiceImpl.findAll();
    }

    /**
     * Update product item cart.
     *
     * @param shoppingCartDTO the shopping cart dto
     * @param ids             the ids
     * @return the cart
     */
    @PutMapping(value ="/{id}")
    public Cart updateProductItem(@RequestBody CartDTO shoppingCartDTO, @PathVariable("id") Long ids) {
        return cartServiceImpl.updateProduct(shoppingCartDTO, ids);
    }

    /**
     * Delete product item.
     *
     * @param ids the ids
     */
    @DeleteMapping(value ="/{id}")
    public void deleteProductItem(@PathVariable("id") Long ids) {
        cartServiceImpl.deleteProduct(ids);
    }

    /**
     * Clear cart.
     *
     * @param object the object
     */
    @DeleteMapping
    public void ClearCart(Object object) {
        cartServiceImpl.clearShoppingCart(object);
    }

    /**
     * Purchase products.
     *
     * @param id the id
     */
    @RequestMapping(method = RequestMethod.POST, value = "/purchase/{id}")
    public void purchaseProducts(@PathVariable("id") Long id) {
        cartServiceImpl.purchaseProducts(id);
    }
}
