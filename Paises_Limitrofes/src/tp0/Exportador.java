package tp0;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exportador {
	BufferedWriter writer = null;

	public Exportador() {}

	public void crearArchivo(String nombre) throws IOException {
		writer = new BufferedWriter(new FileWriter(new File(nombre)));
	}

	public void cerrarArchivo() {
		try {
			writer.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void escribirCaracter(char caracter) {
		try {
			writer.write(caracter);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void escribirString(String cadena) {
		try {
			writer.write(cadena);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}