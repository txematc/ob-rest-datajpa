package com.example.obrestdatajpa.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.obrestdatajpa.entiti.Libros;
import com.example.obrestdatajpa.repository.LibrosRepository;

@RestController
public class LibroController {
	private final Logger log = LoggerFactory.getLogger(LibroController.class); //Está linea de codigo opermite crear mensajes a lo largo del programa
	
	//atributos
	private LibrosRepository librosRepository;
	
	//constructor
	public LibroController(LibrosRepository librosRepository) {
		this.librosRepository = librosRepository;
	
	}
	//CRUD sobre la entidad Libros
	
	//Buscar todos los libros
	@GetMapping("/api/libros")
	public List<Libros> findAll() {
		
		//recurar y devolver de la BBDD
		return librosRepository.findAll();
		
	}

	//Buscar un solo  libro en base de datos según su Id
	
	@GetMapping("/api/libros/{id}")
	public ResponseEntity<Libros> findOneById(@PathVariable Long id) {
		Optional<Libros> librosOpt = librosRepository.findById(id);
		//opcion 1
		if (librosOpt.isPresent())
			return ResponseEntity.ok(librosOpt.get()) ;
		else
			return ResponseEntity.notFound().build();
	}
	
	
	//Crear un nuevo libro en BBDD
	
	@PostMapping("/api/libro")
	public ResponseEntity<Libros> create(@RequestBody Libros libros, @RequestHeader HttpHeaders headers) {
		
		System.out.println(headers.get("User-Agent"));
		//guardar el libro recibido en la BBDD
		if(libros.getId()!= null) {
			log.warn("Este libro creado ya tiene una id, por lo que sera una modificación");
			System.out.println("Este libro creado ya tiene una id, por lo que sera una modificación");
			//quiere decir que existe el id y por tanto no es una creación
			return ResponseEntity.badRequest().build();
		}
		Libros result = librosRepository.save(libros);
		
		return ResponseEntity.ok(result);
		
	}
	
	
	//Actualizar un libro existente en BBDD
	@PutMapping ("/api/libros/actualizar")
	public ResponseEntity<Libros> update(@RequestBody Libros libro) {
		if(libro.getId() == null) { //si no tiene id quiere decir que es nuevo
			log.warn("El libro cargado no existe aún");
			return ResponseEntity.badRequest().build();
			
		}
		if(!librosRepository.existsById(libro.getId())) {
			log.warn("El libro cargado no existe aún");
			return ResponseEntity.notFound().build();
			
		}
		//El proceso de actualización
			
		Libros result = librosRepository.save(libro);
		return ResponseEntity.ok(result);
	
	}
	
	//Borrar un libro en base de datos
	@DeleteMapping ("/api/libros/borrar/{id}")
	public ResponseEntity<Libros> delete(@PathVariable Long id){
		librosRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
