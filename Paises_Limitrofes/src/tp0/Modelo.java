package tp0;

import java.util.List;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.Graphs;
import org.jgrapht.graph.SimpleGraph;

public class Modelo {
	private ColeccionLimitrofes S;
	private Exportador salida;

	public Modelo() {
		S = new ColeccionLimitrofes();
		salida = new Exportador();
	}

	public void generarS(SimpleGraph<Integer, DefaultEdge> grafo) {
		int numeroVertices = grafo.vertexSet().size();
		GrupoLimitrofes grupo;
		Integer paisVertice;
		List<Integer> limitrofes;

		for (int i = 1; i <= numeroVertices; ++i) {
			paisVertice = new Integer(i);
			grupo = new GrupoLimitrofes(paisVertice);
			limitrofes = Graphs.neighborListOf(grafo, paisVertice);
			for (Integer paisLimitrofe : limitrofes) {
				grupo.agregarPais(paisLimitrofe);
			}
			S.agregarSubconjunto(grupo);
		}
	}

	public void exportarModelo(String rutaArchivoDestino) {
		try {
			salida.crearArchivo(rutaArchivoDestino);
		}
		catch (Exception e) {
			System.out.println("Error al crear archivo de salida");
			return;
		}
		salida.escribirString("// Variables Bivalentes\n");
		S.exportarVariables(salida);

		salida.escribirString("\n// Objetivo\n");
		salida.escribirString("minimize\n");
		S.exportarFuncional(salida);

		salida.escribirString("\n// Modelo\n");
		salida.escribirString("subject to {\n");
		S.exportarRestricciones(salida);
		salida.escribirString("}");

		salida.cerrarArchivo();
	}

	public void imprimir() {
		System.out.println("MODELO RADARES");
		System.out.println("-----------------");
		System.out.println();
		System.out.println("Numero de Paises: " + S.getCantidadSubconjuntos());
		System.out.println();
		S.imprimir();
	}
}