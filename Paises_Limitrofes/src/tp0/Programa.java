package tp0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class Programa {
	private static SimpleGraph<Integer, DefaultEdge> grafo =
			new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
	private static int cantidadVertices;

	public static void main(String[] args) {
		String rutaArchivo = args[0];
		String rutaArchivoDestino = args[1];
		Modelo modelo = new Modelo();
		try {
			generarGrafo(rutaArchivo);
		}
		catch (IOException e) {
			System.out.print("No existe el archivo: " + rutaArchivo);
			System.exit(0);
		}
		modelo.generarS(grafo);
		modelo.exportarModelo(rutaArchivoDestino);
		modelo.imprimir();
//		Heuristica.correr(grafo);
	}

	public static void generarGrafo(String rutaArchivo) throws IOException {
		BufferedReader reader;
		reader = new BufferedReader(new FileReader(rutaArchivo));
		String line = null;
		String[] argumentos;
		while ((line = reader.readLine()) != null) {
			argumentos = line.split("\\s+");

			if (argumentos[0].charAt(0) == 'e') {
				grafo.addEdge(Integer.valueOf(argumentos[1]),
						Integer.valueOf(argumentos[2]));
			}
			else if (argumentos[0].charAt(0) == 'p') {
				cantidadVertices = Integer.valueOf(argumentos[2]);

				for (int i = 1; i <= cantidadVertices; ++i) {
					grafo.addVertex(new Integer(i));
				}
			}
		}
		reader.close();
	}
}