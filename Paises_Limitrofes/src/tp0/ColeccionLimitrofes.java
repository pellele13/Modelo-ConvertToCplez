package tp0;

import java.util.ArrayList;

public class ColeccionLimitrofes {
	private ArrayList<GrupoLimitrofes> coleccion;

	public ColeccionLimitrofes() {
		coleccion = new ArrayList<GrupoLimitrofes>();
	}

	public int getCantidadSubconjuntos() {
		return coleccion.size();
	}

	public void agregarSubconjunto(GrupoLimitrofes subconjunto) {
		coleccion.add(subconjunto);
	}

	public void exportarRestricciones(Exportador salida) {
		for (GrupoLimitrofes grupo : coleccion) {
			salida.escribirString("\t" + grupo.generarRestriccion() + "\n");
		}
	}

	public void imprimir() {
		for (GrupoLimitrofes grupo : coleccion) {
			grupo.imprimir();
			System.out.println();
		}
	}

	public void exportarVariables(Exportador salida) {
		for (int bivalente = 1; bivalente <= coleccion.size(); ++bivalente) {
			salida.escribirString("dvar int+ Y" + bivalente + ";\n");
		}
	}

	public void exportarFuncional(Exportador salida) {
		for (int bivalente = 1; bivalente < coleccion.size(); ++bivalente) {
			salida.escribirString("Y" + bivalente + " + ");
		}
		salida.escribirString("Y" + coleccion.size() + ";\n");
	}
}