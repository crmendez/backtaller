package com.tallervi.Controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.tallervi.Model.Juegos;
import com.tallervi.Repository.JuegosRepository;
import com.tallervi.Exception.ResourceNotFoundException;

@Validated
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")

public class JuegosController {
	
	@Autowired
	private JuegosRepository juegosRepository;
	
	//GetAll
	@GetMapping(value = "/juegos") 
	public List<Juegos> getCliente() {
        return juegosRepository.findAll(Sort.by("id"));
        }
	
	//GetById
	@GetMapping(value = "/juegos/{id}")
	public Juegos findByJuegoId (@PathVariable Integer id){ 
        return juegosRepository.findById(id).orElseThrow(()
       		 -> new ResourceNotFoundException("Juego "+id+" no encontrado"));
        }
	
	//Get ByNombre
	@GetMapping(value = "/juegos/find") 
	public List<Juegos> getNombre(@RequestParam (required=true) String nombre) {
        //return juegosRepository.findBynombre(nombre);
		return juegosRepository.findBynombreContaining(nombre);
        }
	
	//Post
	@PostMapping(value = "/juegos")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Juegos save(@Valid @RequestBody Juegos juego) {
		return juegosRepository.save(juego);
	 }
	
	//Put
	@PutMapping(value = "/juegos/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public ResponseEntity<Juegos> updateJuego(@PathVariable Integer id,
			@Valid @RequestBody Juegos nuevoJuego){
		
		return juegosRepository.findById(id).map(juego -> {
			juego.setNombre(nuevoJuego.getNombre());
			juego.setAnio(nuevoJuego.getAnio());
			juego.setRanking(nuevoJuego.getRanking());
			juego.setJugadores(nuevoJuego.getJugadores());
			juegosRepository.save(juego);
			return ResponseEntity.ok(juego);
		}).orElseThrow(() -> new ResourceNotFoundException
				("Cliente "+id+" no encontrado"));
	}
	
	//Delete
	@DeleteMapping(value = "/juegos/{id}")
	public ResponseEntity<?> deleteJuego(@PathVariable Integer id){

		return juegosRepository.findById(id).map(juego -> {
		juegosRepository.delete(juego);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
        ).orElseThrow(() -> new ResourceNotFoundException
        		("Juego "+id+" no encontrado"));
    }
		
	
}
