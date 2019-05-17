package br.coursera;

public interface ServicoRemoto {
	
	public ContaCorrente recuperarConta(String numeroConta);
	public void persistirConta(String numeroConta, Double saldo);

}
