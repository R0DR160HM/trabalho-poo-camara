// Rodrigo Heinzen de Moraes
// Gabriel Eduardo Pereira
// Gustavo Adriano Valin


import java.time.LocalDate;

public class ProjetoDeLei {
	
	private static long ultimoProjeto = 0;
	private long numeroProjeto;
	
	protected String titulo;
	protected LocalDate dataApresentacao;
	protected LocalDate dataAprovacao;

	public ProjetoDeLei(String titulo, LocalDate dataApresentacao) {
		this.setNumeroProjeto();
		this.setTitulo(titulo);
		this.setDataApresentacao(dataApresentacao);
	}
	
	private void setNumeroProjeto() {
		ProjetoDeLei.ultimoProjeto++;
		this.numeroProjeto = ProjetoDeLei.ultimoProjeto;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public void setDataApresentacao(LocalDate dataApresentacao) {
		this.dataApresentacao = dataApresentacao;
	}
	
	public LocalDate getDataApresentacao() {
		return this.dataApresentacao;
	}
	
	public void setDataAprovacao(LocalDate dataAprovacao) {
		if (this.dataApresentacao == null) {
			throw new IllegalArgumentException("Informe uma dataApresentacao!");
		} else if (dataAprovacao.isBefore(this.dataApresentacao)) {
			throw new IllegalArgumentException("Um projeto não pode ser aprovado antes de ser apresentado!");
		} else {
			this.dataAprovacao = dataAprovacao;
		}
	}
	
	public LocalDate getDataAprovacao() {
		return this.dataAprovacao;
	}
	
	public boolean isAprovado() {
		return this.dataAprovacao != null;
	}
	
	public long getNumeroProjeto() {
		return this.numeroProjeto;
	}
	
	public String mostrar() {
		String texto = "Projeto " + this.titulo
					 + "\nNúmero " + this.numeroProjeto
					 + "\nApresentado em: " + this.dataApresentacao; 
		if (this.isAprovado()) {
			texto += "\nAprovado em: " + this.dataAprovacao;
		}
		return texto;
	}

}
