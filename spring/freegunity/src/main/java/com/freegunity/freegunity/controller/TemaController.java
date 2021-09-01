package com.freegunity.freegunity.controller;


import com.freegunity.freegunity.model.Tema;
import com.freegunity.freegunity.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tema")
public class TemaController {

    @Autowired // Puxar todos os métodos que possuem no repository
    private TemaRepository repository;

    @GetMapping
    public ResponseEntity<List<Tema>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")// Url que puxa o método
    public ResponseEntity<Tema> getById(@PathVariable long id){
        return repository.findById(id).map(Resp -> ResponseEntity.ok(Resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Tema>> getByTema(@PathVariable String titulo){
        return ResponseEntity.ok(repository.findAllByTemaContainingIgnoreCase(titulo));
    }
    @PostMapping
    public ResponseEntity<Tema> post(@RequestBody Tema tema){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
    }
    @PutMapping
    public ResponseEntity<Tema> put(@RequestBody Tema tema){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
    }
    @DeleteMapping("/{id}")
    public void delete (@PathVariable long id){
        repository.deleteById(id);
    }

}
