package unPaquete;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Carrera c1 = new Carrera("05");
		c1.resolver();
		c1.mostrarResultado();
		c1.imprimirSolucion();
	}

}
