package com.example.persona;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/personas")
public class PersonaController {
	
	private final PersonaRepository personaRepository;

	private PersonaController(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}

	// Apaño temporal para poder llamar desde Android, ya lo haremos bien
	@GetMapping
	private ResponseEntity<String> findAll() {
		Iterable<Persona> cashCardIterable = personaRepository.findAll();
		return ResponseEntity.ok(cashCardIterable.toString());
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
