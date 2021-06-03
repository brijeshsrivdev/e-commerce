package com.ecommerce.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * The type User.
 */
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name = "USER_T")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "uname")
    private String uname;

    @Column(name = "email")
    private String email;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//    private Set<Cart> shoppingCarts = new HashSet<>();

    /**
     * Instantiates a new User.
     *
     * @param email the email
     * @param name  the name
     */
    public User(String email, String name) {
        this.email = email;
        this.uname = name;
    }
}
