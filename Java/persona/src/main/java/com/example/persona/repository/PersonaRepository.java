package com.example.persona.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.persona.entity.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long>, PagingAndSortingRepository<Persona, Long> {
	
}
