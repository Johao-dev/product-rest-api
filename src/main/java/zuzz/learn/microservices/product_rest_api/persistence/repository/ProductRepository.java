package zuzz.learn.microservices.product_rest_api.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import zuzz.learn.microservices.product_rest_api.persistence.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("UPDATE Product SET stock = ?2 WHERE id = ?1")
    Product updateStockById(Long id, Integer newStock);

    @Query("UPDATE Product SET name = ?2, stock = ?3, category = ?4 WHERE id = ?1")
    Product updateProduct(Long id, String name, Integer stock, String category);
}
