package br.coursera;

import java.util.ArrayList;
import java.util.List;

import br.coursera.testes.MockHardware;
import br.coursera.testes.MockServicoRemoto;

public class CaixaEletronico {
	private ContaCorrente contaCorrenteRecuperada;

	List<ContaCorrente> contas = new ArrayList<ContaCorrente>();

	public String login(String numeroConta, Hardware hardware) {

		hardware.pegarNumeroDaContaCartao(numeroConta);

		return "Usuario autenticado";

	}

	public String depositar(String numeroContaCorrente, ServicoRemoto servicoRemoto, Hardware hardware, double saldo,
			boolean leituraEnvelope) {
		contaCorrenteRecuperada = servicoRemoto.recuperarConta(numeroContaCorrente);

		if (contaCorrenteRecuperada != null && leituraEnvelope == true) {
			servicoRemoto.persistirConta(contaCorrenteRecuperada.getNumeroConta(), saldo);

			return hardware.lerEnvelope();
		}

		throw new LerEnvelopeException("Envelope com problema nao foi possivel receber");

	}

	public String sacar(String numeroContaCorrente, ServicoRemoto servicoRemoto, Hardware hardware, double valor) {
		contaCorrenteRecuperada = servicoRemoto.recuperarConta(numeroContaCorrente);
		if ((contaCorrenteRecuperada.getSaldo() - valor) >= 0) {
			servicoRemoto.persistirConta(contaCorrenteRecuperada.getNumeroConta(), contaCorrenteRecuperada.getSaldo() - valor);

			return hardware.entregarDinheiro();

		}

		throw new SaldoInsuficienteException("Saldo insuficiente");

	}

	public String saldo(String numeroContaCorrente, ServicoRemoto servicoRemoto) {
		contaCorrenteRecuperada = servicoRemoto.recuperarConta(numeroContaCorrente);

		return "O saldo é R$" + contaCorrenteRecuperada.getSaldo();

	}
}
