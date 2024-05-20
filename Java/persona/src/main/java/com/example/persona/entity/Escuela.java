package com.example.persona.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Escuela {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String especialidad;
    private int numeroDeCaseta;

    public Escuela() {
    }

	public Escuela(Long id, String nombre, String especialidad, int numeroDeCaseta) {
		this.id = id;
		this.nombre = nombre;
		this.especialidad = especialidad;
		this.numeroDeCaseta = numeroDeCaseta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public int getNumeroDeCaseta() {
		return numeroDeCaseta;
	}

	public void setNumeroDeCaseta(int numeroDeCaseta) {
		this.numeroDeCaseta = numeroDeCaseta;
	}


}
