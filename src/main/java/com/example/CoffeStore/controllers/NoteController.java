package com.example.CoffeStore.controllers;

import com.example.CoffeStore.dtos.NoteDTO;
import com.example.CoffeStore.models.Note;
import com.example.CoffeStore.services.NoteServce;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/note")
public class NoteController {
    @Autowired
    NoteServce noteServce;
    @PostMapping
    public ResponseEntity<Object> createNote(@RequestBody NoteDTO noteDTO){
        var note = new Note();
        BeanUtils.copyProperties(noteDTO,note);
        return noteServce.createNote(note);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") UUID id){
        return noteServce.getNoteByID(id);
    }
    @GetMapping
    public ResponseEntity<List<Note>>getAll(){
        return  noteServce.getAllNote();
    }
    @PutMapping
    public  ResponseEntity<Object> editNote(@PathVariable(name = "id") UUID id,@Valid NoteDTO noteDTO){
        return noteServce.editNote(id, noteDTO);
    }
    @DeleteMapping ResponseEntity<Object> deleteNote(UUID id){
        return noteServce.deleteNote(id);
    }
}
