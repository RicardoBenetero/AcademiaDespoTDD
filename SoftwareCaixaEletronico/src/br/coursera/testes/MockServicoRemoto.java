package br.coursera.testes;

import java.util.ArrayList;
import java.util.List;

import br.coursera.ContaInexistenteException;
import br.coursera.ServicoRemoto;

public class MockServicoRemoto implements ServicoRemoto {
	List<ContaCorrente> contas = new ArrayList<ContaCorrente>();
	
	public MockServicoRemoto(List<ContaCorrente> contas) {
	
		this.contas = contas;
		
	}
	
	public String  recuperarConta(String numeroConta) {
		for(ContaCorrente contaCorrente : contas){
			if(contaCorrente.getNumeroConta() == numeroConta){
				return contaCorrente.getNumeroConta();
			}
			}
		 
			throw new ContaInexistenteException("Não foi possível autenticar o usuário");
		}
		
		//return "Não foi possível autenticar o usuário";



	@Override
	public void persistirConta(String numeroConta, Double saldo) {
		/*
		ContaCorrente conta = null;
		String contaCorrente = recuperarConta(numeroConta);
		if(contaCorrente != null){
			conta.setSaldo(saldo);
		}
	 
		 */
		for(ContaCorrente contaCorrente : contas){
			if(contaCorrente.getNumeroConta() == numeroConta){
				contaCorrente.setSaldo(saldo);
			}
		
}
	}
}

