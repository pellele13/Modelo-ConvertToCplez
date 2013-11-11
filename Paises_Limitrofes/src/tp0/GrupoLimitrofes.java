package tp0;

import java.util.ArrayList;

public class GrupoLimitrofes {
	private Integer pais;
	private ArrayList<Integer> limitrofes;

	public GrupoLimitrofes(Integer paisVertice) {
		pais = paisVertice;
		limitrofes = new ArrayList<Integer>();
		limitrofes.add(paisVertice);
	}

	public void agregarPais(Integer pais) {
		limitrofes.add(pais);
	}

	public Integer getPaisVertice() {
		return pais;
	}

	public String generarRestriccion() {
		StringBuffer restriccion = new StringBuffer();
		restriccion.append("Pais" + pais.toString() + ":");
		for (Integer bivalente : limitrofes) {
			restriccion.append(" Y" + bivalente.toString() + " +");
		}
		restriccion.deleteCharAt(restriccion.length() - 1);
		restriccion.append(">= 1;");
		return restriccion.toString();
	}

	public void imprimir() {
		System.out.println("Pais Vertice: " + pais.toString());
		System.out.println("Limitrofes: " + limitrofes.toString());
	}
}