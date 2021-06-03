package com.ecommerce;

import com.ecommerce.entities.Product;
import com.ecommerce.entities.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Ecommerce application.
 */
@SpringBootApplication
public class EcommerceApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("user1@gmail.com","user1"));
        users.add(new User("user2@gmail.com","user2"));
    }

	/**
	 * Runner command line runner.
	 *
	 * @param productService the product service
	 * @param userRepository the user repository
	 * @return the command line runner
	 */
	@Bean
	@Profile(value = "local")
	CommandLineRunner runner(ProductService productService, UserRepository userRepository) {
		return args -> {
			productService.save(new Product(1L, "PRODUCT-A", 300.00, "http://placehold.it/100x100"));
			productService.save(new Product(2L, "PRODUCT-B", 200.00, "http://placehold.it/100x100"));
			productService.save(new Product(3L, "PRODUCT-C", 100.00, "http://placehold.it/100x100"));
			productService.save(new Product(4L, "PRODUCT-D", 5.00, "http://placehold.it/100x100"));
			productService.save(new Product(5L, "PRODUCT-E", 3.00, "http://placehold.it/100x100"));
			productService.save(new Product(6L, "PRODUCT-F", 500.00, "http://placehold.it/100x100"));
			productService.save(new Product(7L, "PRODUCT-G", 30.00, "http://placehold.it/100x100"));
			userRepository.saveAll(users);
		};
	}
}
