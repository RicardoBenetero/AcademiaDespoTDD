package br.coursera.academia.despo;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
	
	private String nome;
	
	private Map<String, Integer> tipos = new HashMap<String, Integer>();
	public void adicionaPonto(int ponto, String tipo) {
		tipos.put(tipo, + ponto);
		
	}
	public String getNome() {
		return nome;
	}
	public Map<String, Integer> getPontuacao() {
		return tipos;
	}
	public int getPontos(String tipo){
		if(tipos.containsKey(tipo)){
			return tipos.get(tipo);
		}
		return 0;
}
}
