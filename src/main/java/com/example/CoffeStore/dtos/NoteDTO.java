package com.example.CoffeStore.dtos;

import com.example.CoffeStore.models.Client;
import com.example.CoffeStore.models.Drinks;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

public record NoteDTO(@NotBlank Date date, @NotBlank List<Drinks> drinks,@NotBlank Client client,@NotBlank int totalValue) {
}
