package br.coursera.academia.despo;

import java.util.List;

public class MockPlacar implements Placar {
	
	private Armazenamento armazenamento;
	
	public MockPlacar(Armazenamento armazenamento) {
		this.armazenamento = armazenamento;
		
		
	}

	@Override
	public void registrarPonto(Usuario usuario, int ponto, String tipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] retornarTodosPontosDoUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> retornarRankingTipoPonto(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

}
