package br.coursera;

public interface ServicoRemoto {
	
	public String recuperarConta(String numeroConta);
	public void persistirConta(String numeroConta, Double saldo);

}
