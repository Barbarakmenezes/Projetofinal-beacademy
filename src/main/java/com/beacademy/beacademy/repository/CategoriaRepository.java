package com.beacademy.beacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beacademy.beacademy.model.Categoria;
import com.beacademy.beacademy.model.Postagem;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Long> {
	public List<Categoria> findAllByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);

}
