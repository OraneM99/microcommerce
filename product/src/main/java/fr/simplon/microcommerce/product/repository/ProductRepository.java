package fr.simplon.microcommerce.product.repository;

import fr.simplon.microcommerce.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Product, Long> {
}
