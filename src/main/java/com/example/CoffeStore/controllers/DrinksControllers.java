package com.example.CoffeStore.controllers;

import com.example.CoffeStore.dtos.DrinksDto;
import com.example.CoffeStore.models.Drinks;
import com.example.CoffeStore.services.DrinksService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/drinks")
public class DrinksControllers {
    @Autowired
    DrinksService drinksService;
    @PostMapping
    public ResponseEntity<Object> createDrink(@RequestBody @Valid DrinksDto drinksDto){
        var drink = new Drinks();
        BeanUtils.copyProperties(drinksDto,drink);
        return ResponseEntity.status(HttpStatus.CREATED).body(drinksService.createDrink(drink));
    }
    @GetMapping
    public ResponseEntity<List<Drinks>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(drinksService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneDrink(@PathVariable(value = "id")UUID id){
        return drinksService.getById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> editDrink(@PathVariable(value = "id") UUID id, @RequestBody @Valid DrinksDto drinksDto){
        return drinksService.editDrink(drinksDto,id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id")UUID id){
        return drinksService.deleteDrink(id);
    }
}
