package com.example.obrestdatajpa.entiti;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Libros {
	
	//Atributos
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String autor;
	private Integer paginas;
	private Double precio;
	private LocalDate releaseDate;
	private Boolean online;
	
	//Constructores
	public Libros() {
		
	}

	public Libros(Long id, String titulo, String autor, Integer paginas, Double precio, LocalDate releaseDate,
			Boolean online) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
		this.precio = precio;
		this.releaseDate = releaseDate;
		this.online = online;
	}


	
	//getter y setter
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Boolean getOnline() {
		return online;
	}

	public void setOnline(Boolean online) {
		this.online = online;
	}
	
		
}
