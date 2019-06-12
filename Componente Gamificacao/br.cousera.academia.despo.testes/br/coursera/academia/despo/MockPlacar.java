package br.coursera.academia.despo;

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
		// TODO Auto-generated method stub
		return null;
	}

}
