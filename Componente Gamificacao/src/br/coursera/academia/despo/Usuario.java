package br.coursera.academia.despo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Usuario {

	private String nome;

	public Usuario(String nome) {
		this.nome = nome;

	}

	private Map<String, Integer> tipos = new HashMap<String, Integer>();

	public void adicionaPonto(int ponto, String tipo) {
		tipos.put(tipo, ponto);

	}

	public String getNome() {
		return nome;
	}

	public Map<String, Integer> getPontuacao() {
		return tipos;
	}

	public int getPontos(String tipo) {
		if(tipos.containsKey(tipo)){
			return tipos.get(tipo);
		}
		return 0;
}

	public String getTipos() {
		String tipoPonto = "";
		Set<String> chaves = tipos.keySet();
		for (String chave : chaves) {
			if (chave != null)
				tipoPonto += chave + ";";
		}

		return tipoPonto;
	}

	public boolean temAlgumTipoDePonto() {
		if (tipos.isEmpty()) {
			return false;
		}
		return true;
	}
}
