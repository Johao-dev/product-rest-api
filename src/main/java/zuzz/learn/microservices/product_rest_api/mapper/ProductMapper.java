package zuzz.learn.microservices.product_rest_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import zuzz.learn.microservices.product_rest_api.persistence.entity.Product;
import zuzz.learn.microservices.product_rest_api.service.dto.ProductDto;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    Product toEntity(ProductDto dto);

    ProductDto toDto(Product product);
}
