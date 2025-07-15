package zuzz.learn.microservices.product_rest_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import zuzz.learn.microservices.product_rest_api.persistence.entity.Product;
import zuzz.learn.microservices.product_rest_api.service.ProductService;
import zuzz.learn.microservices.product_rest_api.service.dto.ProductDto;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product productDb = productService.findById(id);

        return productDb == null ?
            ResponseEntity.notFound().build() :
            ResponseEntity.ok(productDb);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ProductDto productDto, BindingResult bindingResults) {
        return bindingResults.hasErrors() ?
            ResponseEntity.badRequest().body(bindingResults.getAllErrors()) :
            ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
        @PathVariable Long id,
        @RequestBody ProductDto updateProduct
    ) {
        return ResponseEntity.ok(productService.updateProduct(id, updateProduct));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateStock(@PathVariable Long id, @RequestBody Integer newStock) {
        return ResponseEntity.ok(productService.updateStock(id, newStock));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
