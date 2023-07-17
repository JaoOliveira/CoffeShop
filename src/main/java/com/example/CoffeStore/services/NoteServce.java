package com.example.CoffeStore.services;

import com.example.CoffeStore.dtos.NoteDTO;
import com.example.CoffeStore.models.Note;
import com.example.CoffeStore.repositories.NoteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NoteServce {
    @Autowired
    NoteRepository noteRepository;

    public ResponseEntity<Object> createNote(Note note){
       return ResponseEntity.status(HttpStatus.CREATED).body(noteRepository.save(note));
    }
    public ResponseEntity<Object> getNoteByID(UUID id){
        Optional<Note>note1 = noteRepository.findById(id);
        if(note1.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(note1.get());

    }
    public ResponseEntity<List<Note>> getAllNote(){
        return ResponseEntity.status(HttpStatus.OK).body(noteRepository.findAll());
    }
    public ResponseEntity<Object>editNote(UUID id, NoteDTO noteDTO){
        Optional<Note> note1 = noteRepository.findById(id);
        if (note1.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note not found");
        }
        var note = note1.get();
        BeanUtils.copyProperties(noteDTO,note);
        return ResponseEntity.status(HttpStatus.OK).body(noteRepository.save(note));
    }
    public ResponseEntity<Object> deleteNote(UUID id){
        Optional<Note> note = noteRepository.findById(id);
        if(note.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note not found");
        }
        return  ResponseEntity.status(HttpStatus.OK).body("Note deleted");
    }

}
