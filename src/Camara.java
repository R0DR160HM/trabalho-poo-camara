// Rodrigo Heinzen de Moraes
// Gabriel Eduardo Pereira
// Gustavo Adriano Valin


import java.util.ArrayList;

public class Camara { // contribuição do Ari
	private ArrayList<Partido> partidos = new ArrayList<>();

	public void addPartido(Partido p) {
		partidos.add(p);
	}

	public Partido getPartido(int numero) {
		for (Partido p: partidos) {
			if (p.getNumero() == numero) {
				return p;
			}
		}
		return null;
	}
	
	public int getTotalProjApres() {
		int total = 0;
		for (Partido p : partidos) {
			total += p.getTotalProjApres();
		}
		return total;
	}

	public int getTotalProjAprov() {
		int total = 0;
		for (Partido p : partidos) {
			total += p.getTotalProjAprov();
		}
		return total;
	}

	public double getDesempenhoMedio() {
		double total = 0;
		int contador = 0;
		for (Partido p : partidos) {
			total += p.getMediaDesempenho() * p.getQtdVereadores();
			contador += p.getQtdVereadores();
		}
		return total / contador;
	}

	// aplica uma estratégia de dividir responsabilidades
	public Vereador getVerMaisProjetosAprov() {
		Vereador verMaisProj = null;

		for (Partido par : partidos) {
			Vereador verAtual = par.getVerMaisProjAprov();
			if (verAtual != null) {
				if (verMaisProj == null || verMaisProj.getQtdProjAprov() < verAtual.getQtdProjAprov()) {
					verMaisProj = verAtual;
				}
			}
		}
		return verMaisProj;
	}

	// aplica outra estratégia: pega a lista e faz tudo aqui
	public Vereador getVerMenorDesempenho() {
		Vereador verMenor = null;
		for (Partido p : partidos) {
			ArrayList<Vereador> lista = p.getVereadores();
			for (Vereador v : lista) {
				if (verMenor == null || verMenor.calculaDesempenho() > v.calculaDesempenho()) {
					verMenor = v;
				}
			}
		}
		return verMenor;
	}

	public ArrayList<Vereador> getVereadoresAcimaMedia() {
		ArrayList<Vereador> vereadores = new ArrayList<>();
		double media = this.getDesempenhoMedio();
		for (Partido p : partidos) {
			ArrayList<Vereador> lista = p.getVereadores();
			for (Vereador v : lista) {
				if (v.calculaDesempenho() > media) {
					vereadores.add(v);
				}
			}
		}
		return vereadores;
	}
}