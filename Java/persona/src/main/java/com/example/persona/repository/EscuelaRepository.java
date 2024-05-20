package com.example.persona.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.example.persona.entity.Escuela;
@Repository
public interface EscuelaRepository extends CrudRepository<Escuela, Long>,PagingAndSortingRepository<Escuela,Long>{
	
}



