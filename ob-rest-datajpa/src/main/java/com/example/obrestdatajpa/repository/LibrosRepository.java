package com.example.obrestdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.obrestdatajpa.entiti.Libros;

@Repository
public interface LibrosRepository extends JpaRepository<Libros, Long>{

}
