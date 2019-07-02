package com.tallervi.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tallervi.Model.Juegos;

@Repository
public interface JuegosRepository extends JpaRepository<Juegos, Integer>{
	
	Optional<Juegos> findByName(String nombre);

}
