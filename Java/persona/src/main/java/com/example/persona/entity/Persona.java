package com.example.persona.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record Persona(@Id Long id, String nombre, String apellido, int edad) {
}


