package com.beacademy.beacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.beacademy.beacademy.model.Comentarios;



@Repository
public interface ComentariosRepository  extends JpaRepository <Comentarios, Long>{
	
	public List<Comentarios> findAllByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);

}
