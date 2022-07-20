package service;

import com.example.obrestdatajpa.entiti.Libros;

public class LibrosPrecioCalculadora {
	public double calcularPrecio(Libros libro) {
		double precio = libro.getPrecio();
		if(libro.getPrecio()>300) {
			precio += 5;
		}
		//envio
		precio += 2.99;
		return precio;
	}

}