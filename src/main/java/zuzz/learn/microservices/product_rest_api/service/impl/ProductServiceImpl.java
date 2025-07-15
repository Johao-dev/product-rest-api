package zuzz.learn.microservices.product_rest_api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.NonNull;
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
    public Product save(@NonNull ProductDto newProduct) {
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
    public Product updateProduct(Product updateProduct) {
        return productRepository.updateProduct(updateProduct.getId(),
            updateProduct.getName(), updateProduct.getStock(), updateProduct.getCategory());
    }

    @Override
    public Product updateStock(Long id, Integer newStock) {
        return productRepository.updateStockById(id, newStock);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
