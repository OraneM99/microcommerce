package fr.simplon.microcommerce.inventory.repository;

import fr.simplon.microcommerce.inventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
