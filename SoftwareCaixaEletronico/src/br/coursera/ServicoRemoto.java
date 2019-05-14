package br.coursera;

import br.coursera.testes.ContaCorrente;

public interface ServicoRemoto {
	
	public ContaCorrente recuperarConta(String numeroConta);

}
