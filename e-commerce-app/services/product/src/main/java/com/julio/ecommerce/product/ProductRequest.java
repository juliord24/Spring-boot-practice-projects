package com.julio.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
         Integer id,
         @NotNull(message = "product name is required")
         String name,
         @NotNull(message = "product description is required")
         String description,
         @Positive(message = "Avaliable quantity shld be positive")
         double availableQuantity,
         @Positive(message = "price shld be positive")
         BigDecimal price,
         @NotNull(message = "product category is required")
         Integer categoryId
) {
}
