package fr.simplon.microcommerce.order.repository;

import fr.simplon.microcommerce.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
