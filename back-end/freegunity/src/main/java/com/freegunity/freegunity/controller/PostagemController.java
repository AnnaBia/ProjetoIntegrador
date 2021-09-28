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

import com.freegunity.freegunity.model.Postagem;
import com.freegunity.freegunity.repository.PostagemRepository;

@RestController // INDICA QUE A CLASSE É UM CONTROLADOR
@RequestMapping("/postagem") // PERMITE QUE A API LEIA E LIBERE A REQUISIÇÃO INDEPENDENTE DA ORIGEM
@CrossOrigin(origins = "*", allowedHeaders = "*") // CAMINHO DA URI PARA CHAMAR O CONTROLLER
public class PostagemController {
	// CRIANDO MÉTODOS(ENDPOINTS)
	@Autowired // PASSA A RESPONSABILIDADE DE INSTANCIAÇÃO PARA A SPRING
	private PostagemRepository repository;

	@GetMapping // RETORNA TODOS OS REGISTROS DA TABELA
	public ResponseEntity<List<Postagem>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}") // RETORNA UM REGISTRO DA TABELA PELO ID
	public ResponseEntity<Postagem> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{texto}") // BUSCA UM REGISTRO PELO NOME ATRAVÉS DE UM SUBTITULO
	public ResponseEntity<List<Postagem>> getByDescricao(@PathVariable String texto){
		return ResponseEntity.ok(repository.findAllByTextoContainingIgnoreCase(texto));
	}
	
	@PostMapping // INSERE REGISTRO NA TABELA
	public ResponseEntity<Postagem> post (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@PutMapping // ALTERA REGISTRO DA TABELA
	public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}") // LOCALIZA UM REGISTRO NA TABELA PELO ID E DELETA
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
