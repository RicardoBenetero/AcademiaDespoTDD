package br.coursera;

import java.util.ArrayList;
import java.util.List;

import br.coursera.testes.MockHardware;
import br.coursera.testes.MockServicoRemoto;

public class CaixaEletronico {
	private ContaCorrente contaCorrenteRecuperada;

	List<ContaCorrente> contas = new ArrayList<ContaCorrente>();

	public String login(String numeroConta, MockHardware mock) {

		mock.pegarNumeroDaContaCartao(numeroConta);

		return "Usuario autenticado";

	}

	public String depositar(String numeroContaCorrente, MockServicoRemoto mock, MockHardware mockHardware, double saldo,
			boolean leituraEnvelope) {
		contaCorrenteRecuperada = mock.recuperarConta(numeroContaCorrente);

		if (contaCorrenteRecuperada != null && leituraEnvelope == true) {
			mock.persistirConta(contaCorrenteRecuperada.getNumeroConta(), saldo);

			return mockHardware.lerEnvelope();
		}

		throw new LerEnvelopeException("Envelope com problema nao foi possivel receber");

	}

	public String sacar(String numeroContaCorrente, MockServicoRemoto mock, MockHardware mockHardware, double valor) {
		contaCorrenteRecuperada = mock.recuperarConta(numeroContaCorrente);
		if ((contaCorrenteRecuperada.getSaldo() - valor) >= 0) {
			mock.persistirConta(contaCorrenteRecuperada.getNumeroConta(), contaCorrenteRecuperada.getSaldo() - valor);

			return mockHardware.entregarDinheiro();

		}

		throw new SaldoInsuficienteException("Saldo insuficiente");

	}

	public String saldo(String numeroContaCorrente, MockServicoRemoto mock) {
		contaCorrenteRecuperada = mock.recuperarConta(numeroContaCorrente);

		return "O saldo é R$" + contaCorrenteRecuperada.getSaldo();

	}
}
