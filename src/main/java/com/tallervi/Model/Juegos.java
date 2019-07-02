package com.tallervi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "juegos")
public class Juegos {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	@NotEmpty(message = "Nombre es obligatorio")
	@Size(min=2, message="minimo dos caracteres")
	private String nombre;
	
	@Column(name="anio")
	@NotNull(message = "Anio es obligatorio")
	private int anio;
	
	@Column(name="ranking")
	@NotNull(message = "Ranking debe estar entre 1 y 10")
	private int ranking;
	
	@Column(name="jugadores")
	@NotNull(message = "Cantidad de jugadores minimo 1")
	@Min(1)
	private int jugadores;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public int getJugadores() {
		return jugadores;
	}

	public void setJugadores(int jugadores) {
		this.jugadores = jugadores;
	}

	@Override
	public String toString() {
		return "Juegos [id=" + id + ", nombre=" + nombre + ", anio=" + anio + ", ranking=" + ranking + ", jugadores="
				+ jugadores + "]";
	}


	
	

}
