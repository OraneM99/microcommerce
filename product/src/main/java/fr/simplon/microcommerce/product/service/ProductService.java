package fr.simplon.microcommerce.product.service;

import fr.simplon.microcommerce.product.dto.CreateInventoryRequest;
import fr.simplon.microcommerce.product.dto.CreateProductRequest;
import fr.simplon.microcommerce.product.entity.Product;
import fr.simplon.microcommerce.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final RestClient restClient;

    public ProductService(ProductRepository repository,
                          RestClient restClient) {
        this.repository = repository;
        this.restClient = restClient;
    }

    public Product create(CreateProductRequest request) {

        Product product = new Product(
                request.name(),
                request.category(),
                request.description()
        );

        Product saved = repository.save(product);

        restClient.post()
                .uri("http://localhost:8901/inventory")
                .body(new CreateInventoryRequest(saved.getId()))
                .retrieve()
                .toBodilessEntity();

        return saved;
    }

    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow();
    }
}