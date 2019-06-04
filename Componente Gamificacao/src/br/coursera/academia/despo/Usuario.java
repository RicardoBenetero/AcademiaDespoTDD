package br.coursera.academia.despo;

public class Usuario {
	
	private String nome;
	private int pontuacao;
	
	public void adicionaPonto(int ponto) {
		pontuacao = ponto;
		
	}
	public String getNome() {
		return nome;
	}
	public int getPontuacao() {
		return pontuacao;
	}

}
