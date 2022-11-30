package com.beacademy.beacademy.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.beacademy.beacademy.model.Comentarios;


import com.beacademy.beacademy.repository.ComentariosRepository;



@RestController
@RequestMapping("/comentarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ComentariosController {
	
	 @Autowired
	    private ComentariosRepository comentariosRepository;
	 
	
	 
	 @GetMapping
		public ResponseEntity<List<Comentarios>> getAll(){
			return ResponseEntity.ok(comentariosRepository.findAll());

}
	 
	 
	 @GetMapping("/{id}")
		public ResponseEntity<Comentarios> getById(@PathVariable Long id){
			return comentariosRepository.findById(id)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		}
	 
	
		
		@PostMapping
		public ResponseEntity<Comentarios> post(@Valid @RequestBody Comentarios comentarios) {
			
			return ResponseEntity.status(HttpStatus.CREATED)
					
					
					.body(comentariosRepository.save(comentarios));
			
			
		}
		
		@PutMapping
		 public ResponseEntity<Comentarios> put(@Valid @RequestBody Comentarios comentarios){
	        return comentariosRepository.findById(comentarios.getId())
	            .map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
	            .body(comentariosRepository.save(comentarios)))
	            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    }
		@ResponseStatus(HttpStatus.NO_CONTENT)
		@DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {
			Optional<Comentarios> comentarios = comentariosRepository.findById(id);
			
			if(comentarios.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
			comentariosRepository.deleteById(id);				
		}


	}

