package zuzz.learn.microservices.product_rest_api.service;

import java.util.List;

import lombok.NonNull;
import zuzz.learn.microservices.product_rest_api.persistence.entity.Product;
import zuzz.learn.microservices.product_rest_api.service.dto.ProductDto;

public interface ProductService {

    public Product save(@NonNull ProductDto newProduct);

    public Product findById(Long id);

    public List<Product> findAll();

    public Product updateProduct(Long id, Product updateProduct);

    public Product updateStock(Long id, Integer newStock);

    public void delete(Long id);
}
