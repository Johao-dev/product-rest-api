package zuzz.learn.microservices.product_rest_api.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {

    @NotBlank
    String name;

    @PositiveOrZero
    Integer stock;

    @NotBlank
    String category;
}
