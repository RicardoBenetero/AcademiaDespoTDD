package br.coursera;

import br.coursera.testes.MockServicoRemoto;

public class CaixaEletronico {
	String contaCorrente;

	public String login(String numeroconta, MockServicoRemoto mock) {

		if (mock.recuperarConta(numeroconta).contains(numeroconta)) {
			return "Usu�rio Autenticado";
		} else {
			return "N�o foi poss�vel autenticar o usu�rio";
		}

	}

	public String depositar(String numeroContaCorrente, MockServicoRemoto mock, double saldo) {
		contaCorrente = mock.recuperarConta(numeroContaCorrente);

		if (contaCorrente != null) {

			mock.persistirConta(numeroContaCorrente, saldo);
			return "Dep�sito recebido com sucesso";

		}

		return "Conta inexistente";

	}
}
