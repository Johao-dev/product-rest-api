package zuzz.learn.microservices.product_rest_api.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import zuzz.learn.microservices.product_rest_api.persistence.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("UPDATE products SET stock = ?2 WHERE product_id = ?1")
    Optional<Product> updateStockById(Long id, Integer newStock);
}
