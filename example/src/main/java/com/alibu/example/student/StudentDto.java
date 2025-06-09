package com.alibu.example.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "First Name shld not be empty")
        String firstName,
        @NotEmpty
        String lastName,
        String email,
        Integer schoolId
) {
}
