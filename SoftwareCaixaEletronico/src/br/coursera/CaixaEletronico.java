package br.coursera;

import java.util.ArrayList;
import java.util.List;

import br.coursera.testes.ContaCorrente;
import br.coursera.testes.MockServicoRemoto;

public class CaixaEletronico {
	private String contaCorrenteRecuperada;

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

		mock.persistirConta(numeroContaCorrente, saldo);

		return "Depósito recebido com sucesso";

	}
}
