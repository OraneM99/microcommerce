package fr.simplon.microcommerce.inventory.dto;

public record InventoryResponse(
        String name,
        String category,
        Integer quantity) {
}
