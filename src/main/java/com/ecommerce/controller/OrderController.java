package com.ecommerce.controller;

import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.entities.Order;
import com.ecommerce.entities.OrderProduct;
import com.ecommerce.entities.OrderStatus;
import com.ecommerce.model.OrderProductModel;
import com.ecommerce.service.OrderProductService;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type Order controller.
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    /**
     * The Product service.
     */
    private ProductService productService;
    /**
     * The Order service.
     */
    private OrderService orderService;
    /**
     * The Order product service.
     */
    private OrderProductService orderProductService;

    /**
     * Instantiates a new Order controller.
     *
     * @param productService      the product service
     * @param orderService        the order service
     * @param orderProductService the order product service
     */
    @Autowired
    public OrderController(ProductService productService, OrderService orderService, OrderProductService orderProductService) {
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
    }

    /**
     * List iterable.
     *
     * @return the iterable
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @NotNull Iterable<Order> list() {
        return this.orderService.getAllOrders();
    }

    /**
     * Create response entity.
     *
     * @param form the form
     * @return the response entity
     */
    @PostMapping(value = "/create")
    public ResponseEntity<Order> create(@RequestBody OrderForm form) {
        List<OrderProductModel> formDtos = form.getProductOrders();
        validateProductsExistence(formDtos);
        Order order = new Order();
        order.setStatus(OrderStatus.PAID.name());
        order = this.orderService.create(order);

        List<OrderProduct> orderProducts = new ArrayList<>();
        for (OrderProductModel dto : formDtos) {
            orderProducts.add(orderProductService.create(new OrderProduct(order, productService.getProduct(dto
                    .getProduct()
                    .getId()), dto.getQuantity())));
        }

        order.setOrderProducts(orderProducts);

        this.orderService.update(order);

        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/orders/{id}")
                .buildAndExpand(order.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
    }

    private void validateProductsExistence(List<OrderProductModel> orderProducts) {
        List<OrderProductModel> list = orderProducts
                .stream()
                .filter(op -> Objects.isNull(productService.getProduct(op
                        .getProduct()
                        .getId())))
                .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(list)) {
            new ResourceNotFoundException("Product not found");
        }
    }

    /**
     * The type Order form.
     */
    public static class OrderForm {

        private List<OrderProductModel> productOrders;

        /**
         * Gets product orders.
         *
         * @return the product orders
         */
        public List<OrderProductModel> getProductOrders() {
            return productOrders;
        }

        /**
         * Sets product orders.
         *
         * @param productOrders the product orders
         */
        public void setProductOrders(List<OrderProductModel> productOrders) {
            this.productOrders = productOrders;
        }
    }
}
