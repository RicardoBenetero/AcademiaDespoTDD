package br.coursera.academia.despo;

import java.util.List;
import java.util.Map;

public interface Placar {
	public void registrarPonto(Usuario usuario, int ponto, String tipo);
	public Map<String, Integer> retornarTodosPontosDoUsuario(Usuario usuario);
	public List<String> retornarRankingTipoPonto(String tipo);
}
