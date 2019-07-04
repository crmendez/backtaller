package com.tallervi.Repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tallervi.Model.Juegos;

@Repository
public interface JuegosRepository extends JpaRepository<Juegos, Integer>{
	
	//List<Juegos> findBynombre(String nombre);
	List<Juegos> findBynombreContaining(String nombre);

}
