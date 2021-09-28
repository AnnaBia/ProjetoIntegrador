package com.freegunity.freegunity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freegunity.freegunity.model.Postagem;
//INTERFACE REPOSITORY REPONSÁVEL PELA COMUNICAÇÃO DA API COM O BD
@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	// BUSCAR DADOS SEM LEVAR EM CONSIDERAÇÃO LETRA MAIÚSCULA OU MINÚSCULA
	public List<Postagem> findAllByTextoContainingIgnoreCase (String texto);
}
