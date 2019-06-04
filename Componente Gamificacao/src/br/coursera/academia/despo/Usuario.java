package br.coursera.academia.despo;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
	
	private String nome;
	//private int pontuacao;
	//private String tipo;
	
	private Map<String, Integer> tipos = new HashMap<String, Integer>();
	public void adicionaPonto(int ponto, String tipo) {
		//pontuacao = ponto;
		//this.tipo = tipo;
		tipos.put(tipo, + ponto);
		
	}
	public String getNome() {
		return nome;
	}
	public Map<String, Integer> getPontuacao() {
		return tipos;
	}

}
