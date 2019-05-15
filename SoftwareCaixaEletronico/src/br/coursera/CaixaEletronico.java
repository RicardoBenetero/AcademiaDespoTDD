package br.coursera;

import br.coursera.testes.MockServicoRemoto;

public class CaixaEletronico {
	String contaCorrente;

	public String login(String numeroconta, MockServicoRemoto mock) {

		if (mock.recuperarConta(numeroconta).contains(numeroconta)) {
			return "Usuário Autenticado";
		} else {
			return "Não foi possível autenticar o usuário";
		}

	}

	public String depositar(String numeroContaCorrente, MockServicoRemoto mock, double saldo) {
		contaCorrente = mock.recuperarConta(numeroContaCorrente);

		if (contaCorrente != null) {

			mock.persistirConta(numeroContaCorrente, saldo);
			return "Depósito recebido com sucesso";

		}

		return "Conta inexistente";

	}
}
