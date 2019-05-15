package br.coursera;

import br.coursera.testes.ContaCorrente;
import br.coursera.testes.MockServicoRemoto;


public class CaixaEletronico {
	private ContaCorrente contaCorrente;


	public String login(String numeroconta,MockServicoRemoto mock ) {
		
		if(mock.recuperarConta(numeroconta).contains(numeroconta)) {
		return "Usuário Autenticado";
	}else {
		return "Não foi possível autenticar o usuário";
	}

}
	public String depositar(String numeroContaCorrente, MockServicoRemoto mock, double saldo) {
		
		
			return "Depósito recebido com sucesso";
		
		
		
		
	}
}
