// Rodrigo Heinzen de Moraes
// Gabriel Eduardo Pereira
// Gustavo Adriano Valin

import java.util.ArrayList;

public class Partido {
	private String nome;
	private int numero;
	private ArrayList<Vereador> vereadores = new ArrayList<>();

	public void addVereador(Vereador v) {
		vereadores.add(v);
	}

	public int getTotalProjApres() {
		int total = 0;
		for (Vereador ver : vereadores) {
			total += ver.getQtdProjApres();
		}
		return total;
	}

	public int getTotalProjAprov() {
		int total = 0;
		for (Vereador ver : vereadores) {
			total += ver.getQtdProjAprov();
		}
		return total;
	}

	public double getMediaDesempenho() {
		double total = 0;
		for (Vereador ver : vereadores) {
			total += ver.calculaDesempenho();
		}
		return total / vereadores.size();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		if (numero > 9 && numero < 100) {
			this.numero = numero;
		}
	}

	public Vereador getVerMaisProjAprov() {
		if (vereadores.isEmpty()) {
			return null;
		}
		Vereador maisAprov = vereadores.get(0);
		
		for (Vereador v: vereadores) {
			if (v.getQtdProjAprov() > maisAprov.getQtdProjAprov()) {
				maisAprov = v;
			}
		}
		
		return maisAprov;
	}

	public ArrayList<Vereador> getVereadores() {
		return this.vereadores;
	}
	
	public int getQtdVereadores() {
		return this.vereadores.size();
	}
}