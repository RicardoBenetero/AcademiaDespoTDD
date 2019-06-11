package br.coursera.academia.despo;

import java.util.List;

public interface Placar {
	public void registrarPonto(Usuario usuario, int ponto, String tipo);
	public String[] retornarTodosPontosDoUsuario();
	public List<String> retornarRankingTipoPonto(String tipo);
}