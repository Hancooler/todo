package com.example.todoapp.Controller;

import com.example.todoapp.model.Todo;
import com.example.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Menandakan bahwa ini adalah REST controller
@RequestMapping("/api/todos") // Base path untuk semua endpoint di controller ini
public class TodoController {

    @Autowired // Melakukan dependency injection untuk TodoService
    private TodoService todoService;

    // GET /api/todos - Mengambil semua tugas
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    // GET /api/todos/{id} - Mengambil tugas berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Optional<Todo> todo = todoService.getTodoById(id);
        return todo.map(ResponseEntity::ok) // Jika ditemukan, kembalikan 200 OK dengan data
                   .orElseGet(() -> ResponseEntity.notFound().build()); // Jika tidak, kembalikan 404 Not Found
    }

    // POST /api/todos - Membuat tugas baru
    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo createdTodo = todoService.createTodo(todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED); // Kembalikan 201 Created
    }

    // PUT /api/todos/{id} - Memperbarui tugas
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails) {
        try {
            Todo updatedTodo = todoService.updateTodo(id, todoDetails);
            return ResponseEntity.ok(updatedTodo); // Kembalikan 200 OK dengan data yang diperbarui
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Jika tidak ditemukan, kembalikan 404 Not Found
        }
    }

    // DELETE /api/todos/{id} - Menghapus tugas
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        try {
            todoService.deleteTodo(id);
            return ResponseEntity.noContent().build(); // Kembalikan 204 No Content
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // Jika tidak ditemukan, kembalikan 404 Not Found
        }
    }
}