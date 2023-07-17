package com.example.CoffeStore.services;

import com.example.CoffeStore.dtos.ClientDTO;
import com.example.CoffeStore.models.Client;
import com.example.CoffeStore.models.Drinks;
import com.example.CoffeStore.repositories.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public ResponseEntity<Object> createClient(Client client){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientRepository.save(client));
    }

    public ResponseEntity<Object> getClient(UUID id){
        Optional<Client> client = clientRepository.findById(id);
        if(client.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(client.get());
    }

    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }

    public ResponseEntity<Object> editClient(UUID id, ClientDTO clientDTO){
        Optional<Client> client1 = clientRepository.findById(id);
        if(client1.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        var client = client1.get();
        BeanUtils.copyProperties(clientDTO,client);
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.save(client));
    }

    public ResponseEntity<Object> deleteClient(UUID id){
        Optional<Client> client = clientRepository.findById(id);
        if(client.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        clientRepository.delete(client.get());
        return ResponseEntity.status(HttpStatus.OK).body("Client deleted");
    }

}

