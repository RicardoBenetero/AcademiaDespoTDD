package br.coursera;

import br.coursera.testes.ContaCorrente;

public interface ServicoRemoto {
	
	public String recuperarConta(String numeroConta);
	public void persistirConta(String numeroConta, Double saldo);

}
