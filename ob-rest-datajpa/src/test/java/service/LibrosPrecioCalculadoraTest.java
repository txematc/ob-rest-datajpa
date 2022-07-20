package service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.example.obrestdatajpa.entiti.Libros;

class LibrosPrecioCalculadoraTest {

	@Test
	void CalcularPrecioTest() {
		
		// Configuración
		Libros libro = new Libros(1L, "El señor de los anillos", "autor",1000, 49.99, LocalDate.now(), true);
		LibrosPrecioCalculadora calculadora = new  LibrosPrecioCalculadora();
		
		// Se ejecuta el comportamiento a testar
		double precio = calculadora.calcularPrecio(libro);
		
		// Comprobhaciones de que todo va bien
		assertTrue(precio>0);
		assertEquals(52.980000000000004,precio);
	}

}
