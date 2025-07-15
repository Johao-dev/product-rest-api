package zuzz.learn.microservices.product_rest_api.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {

    @NotBlank(message = "The name field can not be null, empty or contains white space")
    String name;

    @PositiveOrZero(message = "The stock field can not be negative")
    Integer stock;

    @NotBlank(message = "The category field can not be null, empty or contains white space")
    String category;
}
