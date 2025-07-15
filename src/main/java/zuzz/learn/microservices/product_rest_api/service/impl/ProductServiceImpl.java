package zuzz.learn.microservices.product_rest_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import zuzz.learn.microservices.product_rest_api.mapper.ProductMapper;
import zuzz.learn.microservices.product_rest_api.persistence.entity.Product;
import zuzz.learn.microservices.product_rest_api.persistence.repository.ProductRepository;
import zuzz.learn.microservices.product_rest_api.service.ProductService;
import zuzz.learn.microservices.product_rest_api.service.dto.ProductDto;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    @Override
    public Product save(ProductDto newProduct) {
        return productRepository.save(mapper.toEntity(newProduct));
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long id, ProductDto updateProduct) {
        Optional<Product> productOptional = productRepository.findById(id);
        
        Product productDb = null;
        if (productOptional.isPresent()) {
            productDb = productOptional.get();
            productDb.setName(updateProduct.getName());
            productDb.setStock(updateProduct.getStock());
            productDb.setCategory(updateProduct.getCategory());
            productRepository.save(productDb);
        }
        return productDb;
    }
    
    @Override
    public Product updateStock(Long id, Integer newStock) {
        Optional<Product> productOptional = productRepository.findById(id);

        Product productDb = null;
        if (productOptional.isPresent()) {
            productDb = productOptional.get();
            productDb.setStock(newStock);
            productRepository.save(productDb);
        }

        return productDb;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
