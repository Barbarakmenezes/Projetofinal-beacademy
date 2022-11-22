package com.beacademy.beacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beacademy.beacademy.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository <Postagem, Long> {
	
	 List<Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);

}
