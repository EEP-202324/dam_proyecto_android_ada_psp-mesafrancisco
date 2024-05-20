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

import com.example.persona.entity.Persona;
import com.example.persona.repository.PersonaRepository;

@RestController
@RequestMapping("/personas")
public class PersonaController {
	
	private final PersonaRepository personaRepository;

	private PersonaController(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}
//	frases bonitas y fotos de marte 

	@GetMapping
	private ResponseEntity<List<Persona>> findAll(Pageable pageable) {
		Page<Persona> page = personaRepository.findAll(PageRequest.of(pageable.getPageNumber(), // 0
				pageable.getPageSize(), // 20
				pageable.getSortOr(Sort.by(Sort.Direction.ASC, "nombre"))));
		return ResponseEntity.ok(page.getContent());
	}

	@GetMapping("/{requestedId}")
	private ResponseEntity<Persona> findById(@PathVariable Long requestedId) {
		Optional<Persona> personaOptional = personaRepository.findById(requestedId);
		if (personaOptional.isPresent()) {
			return ResponseEntity.ok(personaOptional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	private ResponseEntity<Persona> createPersona(@RequestBody Persona newPersonaRequested) {
		Persona savedPersona = personaRepository.save(newPersonaRequested);
		return ResponseEntity.ok(savedPersona);
	}

	@PutMapping("/{id}")
	private ResponseEntity<Void> updatePersona(@PathVariable Long id, @RequestBody Persona updatedPersona) {
		if (!personaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		updatedPersona.setId(id);
		personaRepository.save(updatedPersona);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<Void> deletePersona(@PathVariable Long id) {
		if (!personaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		personaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
