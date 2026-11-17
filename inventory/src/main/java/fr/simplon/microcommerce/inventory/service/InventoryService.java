package fr.simplon.microcommerce.inventory.service;

import fr.simplon.microcommerce.inventory.dto.CreateInventoryRequest;
import fr.simplon.microcommerce.inventory.dto.UpdateInventoryRequest;
import fr.simplon.microcommerce.inventory.entity.Inventory;
import fr.simplon.microcommerce.inventory.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public void create(CreateInventoryRequest request) {

        Inventory inventory = new Inventory();

        inventory.setProductId(request.productId());
        inventory.setQuantity(0);

        repository.save(inventory);
    }

    public void update(Long productId, UpdateInventoryRequest request) {

        Inventory inventory = repository.findById(productId).orElseThrow();

        inventory.setQuantity(request.quantity());

        repository.save(inventory);
    }
}
