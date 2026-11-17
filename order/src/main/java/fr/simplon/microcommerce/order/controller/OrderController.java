package fr.simplon.microcommerce.order.controller;

import fr.simplon.microcommerce.order.dto.CreateOrderRequest;
import fr.simplon.microcommerce.order.entity.Order;
import fr.simplon.microcommerce.order.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order create(@RequestBody CreateOrderRequest request) {
        return service.create(request);
    }
}
