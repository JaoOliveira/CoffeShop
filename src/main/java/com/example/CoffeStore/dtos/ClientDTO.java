package com.example.CoffeStore.dtos;

import jakarta.validation.constraints.NotBlank;

public record ClientDTO(@NotBlank String name,@NotBlank String cpf) {
}
