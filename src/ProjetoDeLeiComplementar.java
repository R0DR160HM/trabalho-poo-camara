// Rodrigo Heinzen de Moraes
// Gabriel Eduardo Pereira
// Gustavo Adriano Valin

import java.time.LocalDate;

public class ProjetoDeLeiComplementar extends ProjetoDeLei {

	private String artigoLO;
	private short qtdVotosFavoraveis;
	
	public ProjetoDeLeiComplementar(String titulo, LocalDate dataApresentacao, String artigoLO, int qtdVotosFavoraveis) {
		super(titulo, dataApresentacao);
	}
	
	public void setArtigoLO(String artigoLO) {
		this.artigoLO = artigoLO;
	}
	
	public String getArtigoLO() {
		return this.artigoLO;
	}
	
	public void setQtdVotosFavoraveis(short qtdVotosFavoraveis) {
		if (qtdVotosFavoraveis >= 0) {
			this.qtdVotosFavoraveis = qtdVotosFavoraveis;
		} else {
			throw new IllegalArgumentException("A qtdVotosFavoraveis precisa ser positiva ou nula!");
		}
	}
	
	public short getQtdVotosFavoraveis() {
		return this.qtdVotosFavoraveis;
	}
	
	@Override
	public String mostrar() {
		String texto = super.mostrar();
		texto += "\n Artigo da Lei Orgânica: " + this.artigoLO
			   + "\n Recebeu " + this.qtdVotosFavoraveis + " votos";
		return texto;
	}
	
}
