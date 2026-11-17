package fr.simplon.microcommerce.order.service;

import fr.simplon.microcommerce.order.dto.CreateOrderRequest;
import fr.simplon.microcommerce.order.dto.InventoryResponse;
import fr.simplon.microcommerce.order.dto.UpdateInventoryRequest;
import fr.simplon.microcommerce.order.entity.Order;
import fr.simplon.microcommerce.order.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final RestClient restClient;

    public OrderService(OrderRepository repository, RestClient restClient) {
        this.repository = repository;
        this.restClient = restClient;
    }

    public Order create(CreateOrderRequest request) {

        InventoryResponse inventory =
                restClient.get()
                        .uri("http://localhost:8901/inventory/" + request.productId())
                        .retrieve()
                        .body(InventoryResponse.class);

        if (inventory.quantity() < request.quantity()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Stock insuffisant"
            );
        }

        Integer newQuantity = inventory.quantity() - request.quantity();

        restClient.put()
                .uri("http://localhost:8901/inventory/" + request.productId())
                .body(new UpdateInventoryRequest(newQuantity))
                .retrieve()
                .toBodilessEntity();

        Order order = new Order();
        order.setProductId(request.productId());
        order.setQuantity(request.quantity());
        order.setCreatedAt(LocalDateTime.now(ZoneId.systemDefault()));

        return repository.save(order);
    }
}
