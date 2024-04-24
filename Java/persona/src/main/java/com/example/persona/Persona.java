package com.example.persona;

import org.springframework.data.annotation.Id;

record Persona(@Id Long id,String nombre, String apellido, int edad) {
}

