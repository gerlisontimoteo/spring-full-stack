package com.api.lojadegames.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.api.lojadegames.model.Jogo;
import com.api.lojadegames.repository.JogoRepository;


@RestController
@RequestMapping("jogo")
@CrossOrigin("*")
public class JogoController {
	@Autowired
	private JogoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Jogo>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Jogo> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/jogo/{jogo}")
	public ResponseEntity<List<Jogo>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.getAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping("/jogo")
	public ResponseEntity<Jogo> post(@RequestBody Jogo jogo){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(jogo));
	}
	
	@PutMapping
	public ResponseEntity<Jogo> put(@RequestBody Jogo jogo){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(jogo));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}


