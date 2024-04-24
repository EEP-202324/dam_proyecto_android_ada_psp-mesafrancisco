package com.example.persona;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonaApplicationTests {

	@Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldReturnACashCardWhenDataIsSaved() {
        ResponseEntity<String> response = restTemplate.getForEntity("/cashcards/99", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        
        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.id");
        assertThat(id).isEqualTo(99);
        
        String nombre = documentContext.read("$.nombre");
        assertThat(nombre).isEqualTo("Francisco");
        
        String apellido = documentContext.read("$.apellido");
        assertThat(apellido).isEqualTo("Mesa");
        
        int edad = documentContext.read("$.edad ");
        assertThat(edad).isEqualTo(29);
    }
    
    @Test
    void shouldNotReturnACashCardWithAnUnknownId() {
      ResponseEntity<String> response = restTemplate.getForEntity("/cashcards/1000", String.class);

      assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
      assertThat(response.getBody()).isBlank();
    }

    @Test
    void shouldCreateANewCashCard() {
       Persona newPersona = new Persona(null, "Francisco","Mesa",29);
       ResponseEntity<Void> createResponse = restTemplate.postForEntity("/personas", newPersona, Void.class);
       assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
       
       URI locationOfNewPersona = createResponse.getHeaders().getLocation();
       ResponseEntity<String> getResponse = restTemplate.getForEntity(locationOfNewPersona, String.class);
       assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
       
       DocumentContext documentContext = JsonPath.parse(getResponse.getBody());
       Number id = documentContext.read("$.id");
       String nombre = documentContext.read("$.nombre");
       String apellido = documentContext.read("$.apellido");
       int edad = documentContext.read("$.edad ");
       
       assertThat(id).isNotNull();
       assertThat(nombre).isEqualTo("Francisco");
       assertThat(apellido).isEqualTo("Mesa");
       assertThat(edad).isEqualTo(29);
    }

}
