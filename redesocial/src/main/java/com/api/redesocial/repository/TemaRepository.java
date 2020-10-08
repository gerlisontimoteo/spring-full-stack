package com.api.redesocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.redesocial.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long>{
	public List<Tema> findAllByNomeContainingIgnoreCase(String nome);

}
