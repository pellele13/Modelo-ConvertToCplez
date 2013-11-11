package tp0;

import java.util.ArrayList;
import java.util.Collections;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.Graphs;
import org.jgrapht.alg.util.VertexDegreeComparator;
import org.jgrapht.graph.SimpleGraph;

public class Heuristica {

	private Heuristica() {}

	public static void correr(SimpleGraph<Integer, DefaultEdge> grafo) {
		VertexDegreeComparator<Integer, DefaultEdge> comp =
				new VertexDegreeComparator<Integer, DefaultEdge>(grafo);
		ArrayList<Integer> lista = new ArrayList<Integer>();
		Integer verticeApintar;

		while (!grafo.vertexSet().isEmpty()) {
			verticeApintar = Collections.max(grafo.vertexSet(), comp);
			lista.add(verticeApintar);
			grafo.removeAllVertices(Graphs
					.neighborListOf(grafo, verticeApintar));
			grafo.removeVertex(verticeApintar);
		}

		System.out.println("RESULTADO");
		System.out.println("Cantidad de radares colocados: " + lista.size());
		System.out.print("Paises con radares: " + lista.toString());
	}
}