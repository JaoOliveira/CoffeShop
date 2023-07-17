package com.example.CoffeStore.repositories;

import com.example.CoffeStore.models.Drinks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DrinksRepository extends JpaRepository<Drinks, UUID> {

}
