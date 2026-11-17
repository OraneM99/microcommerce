package fr.simplon.microcommerce.order.dto;

public record CreateOrderRequest(
        Long productId,
        Integer quantity) {
}
