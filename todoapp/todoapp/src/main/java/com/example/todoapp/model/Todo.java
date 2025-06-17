package com.example.todoapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity // Menandakan bahwa kelas ini adalah entitas JPA
@Data // Lombok: Otomatis membuat getter, setter, toString, equals, hashCode
@NoArgsConstructor // Lombok: Otomatis membuat konstruktor tanpa argumen
@AllArgsConstructor // Lombok: Otomatis membuat konstruktor dengan semua argumen
public class Todo {

    @Id // Menandakan bahwa ini adalah primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Strategi auto-increment ID
    private Long id;
    private String title;
    private String description;
    private boolean completed; // Status tugas: selesai atau belum

}