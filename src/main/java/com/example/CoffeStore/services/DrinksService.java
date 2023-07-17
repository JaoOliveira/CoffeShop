package com.example.CoffeStore.services;

import com.example.CoffeStore.models.Drinks;
import com.example.CoffeStore.models.Size;
import com.example.CoffeStore.dtos.DrinksDto;
import com.example.CoffeStore.repositories.DrinksRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DrinksService {
    @Autowired
    DrinksRepository drinksReposiory;

    public ResponseEntity<Object> createDrink(Drinks drinks) {
        if (drinks.getSize() == Size.BIG) {
            drinks.setPrice(drinks.getPrice() + 5);
            return ResponseEntity.status(HttpStatus.CREATED).body(drinksReposiory.save(drinks));
        } else if (drinks.getSize() == Size.AVERAGE) {
            drinks.setPrice(drinks.getPrice() + 3);
            return ResponseEntity.status(HttpStatus.CREATED).body(drinksReposiory.save(drinks));
        } else if (drinks.getSize() == Size.SMALL) {
            drinks.setPrice(drinks.getPrice() + 2);
            return ResponseEntity.status(HttpStatus.CREATED).body(drinksReposiory.save(drinks));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Size not found");
        }
    }
    public List<Drinks> getAll(){
        return drinksReposiory.findAll();
    }

    public ResponseEntity<Object> getById(UUID id){
        Optional<Drinks> drink = drinksReposiory.findById(id);
        if(drink.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Drink not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(drink.get());

    }
    public ResponseEntity<Object> editDrink(DrinksDto drinksDTO, UUID id){
        Optional<Drinks> drinks1 = drinksReposiory.findById(id);

        if(drinks1.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Drink not found");
        }
        var drink =drinks1.get();
        BeanUtils.copyProperties(drinksDTO,drink);
        return ResponseEntity.status(HttpStatus.OK).body(drinksReposiory.save(drink));
    }
    public ResponseEntity<Object> deleteDrink(UUID id){
        Optional<Drinks> drinks1 = drinksReposiory.findById(id);
        if(drinks1.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Drink not found");
        }
        drinksReposiory.delete(drinks1.get());
        return ResponseEntity.status(HttpStatus.OK).body("Drink deleted successfully");
    }

}
