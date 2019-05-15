package br.coursera.testes;

import java.util.ArrayList;
import java.util.List;

import br.coursera.ServicoRemoto;

public class MockServicoRemoto implements ServicoRemoto {
	List<ContaCorrente> contas = new ArrayList<ContaCorrente>();
	
	public MockServicoRemoto(List<ContaCorrente> contas) {
	
		this.contas = contas;
		
	}
	
	public String  recuperarConta(String numeroconta) {
		for(ContaCorrente contaCorrente : contas){
			if(contaCorrente.getNumeroConta() == numeroconta){
				return contaCorrente.getNumeroConta();
			}
		}
		return "Não foi possível autenticar o usuário";
}
}
