package com.ecommerce.service;

import com.ecommerce.entities.Cart;
import com.ecommerce.entities.Product;
import com.ecommerce.entities.User;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.CartDTO;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * The type Cart service.
 */
@Service
@Transactional
public class CartServiceImpl implements CartService{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart saveProducts(CartDTO cartDTO) {

        Optional<Product> productOptional = productRepository.findById(cartDTO.getProductId());
        if(!productOptional.isPresent()){
            throw new ResourceNotFoundException("Product is not found in cart");
        }
        Cart cart = new Cart();
        Product product = productOptional.get();
        cart.setProduct(product);
        Optional<User> optionalUser = userRepository.findById(cartDTO.getUserId());
        if(!optionalUser.isPresent()) {
            throw new ResourceNotFoundException("User is not available");
        }
        cart.setUser(optionalUser.get());
        cart.setStatus(cartDTO.getStatus());
        cart.setDate(LocalDate.now());
        cart.setStock(cartDTO.getStock());
        cart.setAmount(product.getPrice() * cartDTO.getStock());
        return cartRepository.save(cart);

    }

    @Override
    public List<Cart> findAll(Long userId) {
        return cartRepository.findByStatusAndId("NOT_PURCHASED",userId);
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findByStatus("NOT_PURCHASED");
    }

    @Override
    public Cart updateProduct(CartDTO cartDTO, Long id) {
        Optional<Cart> updateItemOptional = cartRepository.findById(id);
        if(!updateItemOptional.isPresent()){
            throw new ResourceNotFoundException("Item is not found in cart");
        }
        Cart updateItem = updateItemOptional.get();
        updateItem.setStock(cartDTO.getStock());
        updateItem.setAmount(updateItem.getProduct().getPrice() * cartDTO.getStock());
        return cartRepository.save(updateItem);
    }

    @Override
    public void deleteProduct(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void clearShoppingCart(Object object) {
        cartRepository.deleteAll();
    }


    @Override
    public List<Cart> findByPurchased() {
        return cartRepository.findByStatus("PURCHASED");
    }


    @Override
    public void purchaseProducts(Long id) {
        Optional<Cart> cartOptional = cartRepository.findById(id);
        if(!cartOptional.isPresent()){
            throw new ResourceNotFoundException("Product is missing from cart.");
        }
        Cart cart = cartOptional.get();
        cart.setStatus("PURCHASED");
        cartRepository.save(cart);
    }
}
