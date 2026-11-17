package fr.simplon.microcommerce.order.dto;

public record InventoryResponse(
        String name,
        String category,
        Integer quantity) {
}
