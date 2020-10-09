package com.api.lojadegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.lojadegames.model.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long>{
	public List<Jogo> getAllByTituloContainingIgnoreCase(String titulo);

}
