package fr.simplon.microcommerce.product.dto;

public record CreateProductRequest(
        String name,
        String category,
        String description
) {
}
