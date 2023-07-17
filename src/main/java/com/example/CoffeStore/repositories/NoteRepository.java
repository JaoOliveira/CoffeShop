package com.example.CoffeStore.repositories;

import com.example.CoffeStore.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NoteRepository extends JpaRepository<Note, UUID> {
}
