package br.coursera.academia.despo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MockPlacar implements Placar {

	private Armazenamento armazenamento;

	public MockPlacar(Armazenamento armazenamento) {
		this.armazenamento = armazenamento;

	}

	@Override
	public void registrarPonto(Usuario usuario, int ponto, String tipo) {
		armazenamento.armazenarQuantidadeTipoPontoRecebidaPorUsuario(usuario, ponto, tipo);

	}

	@Override
	public Map<String, Integer> retornarTodosPontosDoUsuario(Usuario usuario) {

		return usuario.getPontuacao();
	}

	@Override
	public List<String> retornarRankingTipoPonto(String tipo) {
		ArrayList<String> pontuacoes = new ArrayList();

		ArrayList<Usuario> usuarios = new ArrayList();

		usuarios = armazenamento.getUsuarios();

		for (Usuario usuario : usuarios) {

			pontuacoes.add(usuario.getPontuacao(tipo));
		}

		return pontuacoes;
	}

}
