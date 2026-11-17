package fr.simplon.microcommerce.inventory.controller;

import fr.simplon.microcommerce.inventory.dto.CreateInventoryRequest;
import fr.simplon.microcommerce.inventory.dto.InventoryResponse;
import fr.simplon.microcommerce.inventory.dto.UpdateInventoryRequest;
import fr.simplon.microcommerce.inventory.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateInventoryRequest request) {
        service.create(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{productId}")
    public void updateInventory(
            @PathVariable Long productId,
            @RequestBody UpdateInventoryRequest request) {
        service.update(productId, request);
    }
}
