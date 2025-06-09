package com.julio.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

//Este es el dto para las request del cliente al servidor, se incluyen validaciones para confirmar que los datos son correctos
public record CustomerRequest(
         String id,
         @NotNull(message = "Customer First Name is required")
         String firstName,
         @NotNull(message = "Customer Last Name is required")
         String lastName,
         @Email(message = "Not a valid email address")
         String email,

         Address address

) {
}
