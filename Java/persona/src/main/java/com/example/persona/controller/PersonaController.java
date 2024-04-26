package com.example.persona.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
	private ResponseEntity<Void> createPersona(@RequestBody Persona newPersonaRequested, UriComponentsBuilder ucb) {
		Persona savedPersona = personaRepository.save(newPersonaRequested);
		URI locationOfNewPersona = ucb.path("personas/{id}").buildAndExpand(savedPersona.id()).toUri();
		return ResponseEntity.created(locationOfNewPersona).build();
	}
}
