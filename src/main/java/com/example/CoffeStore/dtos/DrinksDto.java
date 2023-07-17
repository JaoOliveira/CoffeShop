package com.example.CoffeStore.dtos;
import com.example.CoffeStore.models.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DrinksDto(@NotBlank String name,@NotBlank String ingredient,@NotBlank String imageURL, Size size, int price) {

}
