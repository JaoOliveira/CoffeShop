package com.example.CoffeStore.controllers;

import com.example.CoffeStore.dtos.ClientDTO;
import com.example.CoffeStore.models.Client;
import com.example.CoffeStore.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;
    @PostMapping
    public ResponseEntity<Object> creatAccount(@RequestBody @Valid ClientDTO clientDTO){
        var client = new Client();
        BeanUtils.copyProperties(clientDTO,client);
        return clientService.createClient(client);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getClient(@PathVariable(value = "id") UUID id){
        return clientService.getClient(id);
    }
    @GetMapping
    public ResponseEntity<Object>getAllClient(){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getAllClient());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object>editClient(@RequestBody @Valid ClientDTO clientDTO,@PathVariable(value = "id") UUID id){
        return clientService.editClient(id,clientDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object>deleteClient(@PathVariable UUID id){
        return clientService.deleteClient(id);
    }
}
