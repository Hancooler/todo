package com.example.todoapp.repository;

import com.example.todoapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Menandakan bahwa ini adalah komponen repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    // JpaRepository menyediakan metode CRUD dasar: save, findAll, findById, delete, dll.
    // Anda bisa menambahkan metode kustom di sini jika diperlukan,
    // misalnya: List<Todo> findByCompleted(boolean completed);
}