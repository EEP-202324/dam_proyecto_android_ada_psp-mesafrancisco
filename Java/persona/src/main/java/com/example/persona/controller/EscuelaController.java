package com.example.persona.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.persona.entity.Escuela;
import com.example.persona.entity.Persona;
import com.example.persona.repository.EscuelaRepository;
import com.example.persona.repository.PersonaRepository;

@RestController
@RequestMapping("/escuelas")
public class EscuelaController {
	
	private final EscuelaRepository escuelaRepository;
	
	private EscuelaController(EscuelaRepository escuelaRepository) {
		this.escuelaRepository = escuelaRepository;
	}
	
	@GetMapping
	private ResponseEntity<List<Escuela>> findAll(Pageable pageable) {
		Page<Escuela> page = escuelaRepository.findAll(PageRequest.of(pageable.getPageNumber(), // 0
				pageable.getPageSize(), // 20
				pageable.getSortOr(Sort.by(Sort.Direction.ASC, "nombre"))));
		return ResponseEntity.ok(page.getContent());
	}

	@GetMapping("/{Id}")
	private ResponseEntity<Escuela> findById(@PathVariable Long requestedId) {
		Optional<Escuela> escuelaOptional = escuelaRepository.findById(requestedId);
		if (escuelaOptional.isPresent()) {
			return ResponseEntity.ok(escuelaOptional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	private ResponseEntity<Escuela> createEscuela(@RequestBody Escuela newEscuelaRequested) {
		Escuela savedEscuela = escuelaRepository.save(newEscuelaRequested);
		return ResponseEntity.ok(savedEscuela);
	}

	@PutMapping("/{id}")
	private ResponseEntity<Void> updateEscuela(@PathVariable Long id, @RequestBody Escuela updatedEscuela) {
		if (!escuelaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		updatedEscuela.setId(id);
		escuelaRepository.save(updatedEscuela);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<Void> deleteEscuela(@PathVariable Long id) {
		if (!escuelaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		escuelaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
