package com.ecommerce.entities;

import com.ecommerce.entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

/**
 * The type Cart.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "cart")
public class Cart implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private Long id;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne(fetch = FetchType.EAGER)
        private Product product;

        @Column(name = "stock")
        @NotNull
        private Integer stock;

        @Column(name = "amount")
        private Double amount;

        @Column(name = "status")
        private String status;

        @Column(name = "date")
        private LocalDate date;
}
