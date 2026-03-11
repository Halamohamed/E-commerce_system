package se.lexicon.ecommerce_system.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.ecommerce_system.DTOs.productDTO.ProductRequest;
import se.lexicon.ecommerce_system.DTOs.productDTO.ProductResponse;
import se.lexicon.ecommerce_system.exceptions.ResourceNotFoundException;
import se.lexicon.ecommerce_system.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest productRequest) throws ResourceNotFoundException {
        ProductResponse productResponse = productService.create(productRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(@Valid @RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/search?name")
    public ResponseEntity<List<ProductResponse>> searchByName( @RequestParam String name) {
        return ResponseEntity.ok(productService.searchByName(name));
    }
}
