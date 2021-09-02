package com.freegunity.freegunity.controller;

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

import com.freegunity.freegunity.model.Tema;
import com.freegunity.freegunity.repository.TemaRepository;

@RestController // INDICA QUE A CLASSE É UM CONTROLADOR
@CrossOrigin(origins = "*", allowedHeaders = "*") // PERMITE QUE A API LEIA E LIBERE A REQUISIÇÃO INDEPENDENTE DA ORIGEM
@RequestMapping("/tema") // CAMINHO DA URI PARA CHAMAR O CONTROLLER
public class TemaController {
	// CRIANDO MÉTODOS(ENDPOINTS)
	@Autowired // PASSA A RESPONSABILIDADE DE INSTANCIAÇÃO PARA A SPRING
	private TemaRepository repository;

	@GetMapping // RETORNA TODOS OS REGISTROS DA TABELA
	public ResponseEntity<List<Tema>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}") // RETORNA UM REGISTRO DA TABELA PELO ID
	public ResponseEntity<Tema> getById(@PathVariable long id) {
		return repository.findById(id).map(Resp -> ResponseEntity.ok(Resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/titulo/{titulo}") // BUSCA UM REGISTRO PELO NOME ATRAVÉS DE UM SUBTITULO
	public ResponseEntity<List<Tema>> getByTema(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping // INSERE REGISTRO NA TABELA
	public ResponseEntity<Tema> post(@RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}

	@PutMapping // ALTERA REGISTRO DA TABELA
	public ResponseEntity<Tema> put(@RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
	}

	@DeleteMapping("/{id}") // LOCALIZA UM REGISTRO NA TABELA PELO ID E DELETA
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
