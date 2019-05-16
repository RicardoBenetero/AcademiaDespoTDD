package br.coursera;

import java.util.ArrayList;
import java.util.List;

import br.coursera.testes.ContaCorrente;
import br.coursera.testes.MockServicoRemoto;

public class CaixaEletronico {
	private String contaCorrenteRecuperada;
	private ContaCorrente conta;
	List<ContaCorrente> contas = new ArrayList<ContaCorrente>();

	public String login(String numeroconta, MockServicoRemoto mock) {

		if (mock.recuperarConta(numeroconta).contains(numeroconta)) {
			return "Usuário Autenticado";
		} else {
			return "Não foi possível autenticar o usuário";
		}

	}

	public String depositar(String numeroContaCorrente, MockServicoRemoto mock, double saldo) {
		contaCorrenteRecuperada = mock.recuperarConta(numeroContaCorrente);
System.out.println(contaCorrenteRecuperada +   "------------ contaCorrenteRecuperada");
/*
		if (contaCorrente != null) {
			System.out.println(contaCorrente +   "------------ passou no depositar");
*/
	//	for(ContaCorrente contaCorrente : contas){
		//	String contaRecebidaDeposito = conta.getNumeroConta();
		//	if (contaRecebidaDeposito == contaCorrenteRecuperada ) {
			mock.persistirConta(numeroContaCorrente, saldo);
			
			System.out.println(saldo +   "------------ saldo no depositar");
			return "Depósito recebido com sucesso";
			//}
		//}
		//System.out.println(contaCorrenteRecuperada +   "------------ passou no depositar");
	//	return "Conta inexistente";

	}
}
