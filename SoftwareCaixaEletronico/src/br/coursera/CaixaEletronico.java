package br.coursera;

import java.util.ArrayList;
import java.util.List;

import br.coursera.testes.ContaCorrente;
import br.coursera.testes.MockServicoRemoto;

public class CaixaEletronico {
	private ContaCorrente contaCorrenteRecuperada;

	List<ContaCorrente> contas = new ArrayList<ContaCorrente>();

	public String login(String numeroconta, MockServicoRemoto mock) {

		if (mock.recuperarConta(numeroconta).getNumeroConta().contains(numeroconta)) {
			return "Usu�rio Autenticado";
		} else {
			return "N�o foi poss�vel autenticar o usu�rio";
		}

	}

	public String depositar(String numeroContaCorrente, MockServicoRemoto mock, double saldo) {
		contaCorrenteRecuperada = mock.recuperarConta(numeroContaCorrente);

		mock.persistirConta(contaCorrenteRecuperada.getNumeroConta(), saldo);

		return "Dep�sito recebido com sucesso";

	}

	public String sacar(String numeroContaCorrente, MockServicoRemoto mock, double valor) {
		contaCorrenteRecuperada = mock.recuperarConta(numeroContaCorrente);
		
		mock.persistirConta(contaCorrenteRecuperada.getNumeroConta(), contaCorrenteRecuperada.getSaldo() - valor);
		return "Retire seu dinheiro";
		
	}

	public String saldo(String numeroContaCorrente, MockServicoRemoto mock) {
		contaCorrenteRecuperada = mock.recuperarConta(numeroContaCorrente);

		return "O saldo é R$" + contaCorrenteRecuperada.getSaldo();
		// return "Conta não encontrada";

	}
}
