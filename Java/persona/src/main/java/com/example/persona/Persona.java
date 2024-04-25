package com.example.persona;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
record Persona(@Id Long id, String nombre, String apellido, int edad) {
}

