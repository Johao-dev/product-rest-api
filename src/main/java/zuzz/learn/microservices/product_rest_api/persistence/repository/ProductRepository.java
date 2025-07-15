package zuzz.learn.microservices.product_rest_api.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import zuzz.learn.microservices.product_rest_api.persistence.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
