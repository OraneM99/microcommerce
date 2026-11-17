package fr.simplon.microcommerce.product.controller;

import fr.simplon.microcommerce.product.dto.CreateInventoryRequest;
import fr.simplon.microcommerce.product.dto.CreateProductRequest;
import fr.simplon.microcommerce.product.entity.Product;
import fr.simplon.microcommerce.product.repository.ProductRepository;
import fr.simplon.microcommerce.product.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product create(@RequestBody CreateProductRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return service.findById(id);
    }
}