package com.example.obrestdatajpa;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.obrestdatajpa.entiti.Libros;
import com.example.obrestdatajpa.repository.LibrosRepository;
@EnableWebMvc
@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext contex =   SpringApplication.run(ObRestDatajpaApplication.class, args);
		LibrosRepository repository = contex.getBean(LibrosRepository.class);
		
		
		//CRUD
		
		//crear libro
		Libros libro1 = new Libros(null, "Homo Deus", "Yuval Noah", 450, 29.99,LocalDate.of(2018,12, 1), true);
		Libros libro2 = new Libros(null,"Homo Sapiens", "Yuval Noah", 450,19.99, LocalDate.of(2019, 5,5), true);
		
		//almacenar un libro
		System.out.println("Num libros en base de datos: " +  repository.findAll().size());
		
		repository.save(libro1);
		repository.save(libro2);
		
		//recuperar todos los libros
		System.out.println("Num libros en base de datos: " + repository.findAll().size());
		
		//borrar un libro
		//repository.deleteById(1L);
		
		
		System.out.println("Num libros en base de datos: " + repository.findAll().size());
		
	}

}
