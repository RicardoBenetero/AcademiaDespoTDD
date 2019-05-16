package br.coursera.testes;

public class ContaCorrente {
	
	private String numeroConta;
	private double saldo;
	
	
	public ContaCorrente(String numeroConta) {
		
		this.numeroConta = numeroConta;
	}


	public String getNumeroConta() {
		return numeroConta;
	}


	public void setSaldo(Double valor) {
    this.saldo = saldo + valor;		
	}


	public double getSaldo() {
		return saldo;
	}


	
		
	

}
