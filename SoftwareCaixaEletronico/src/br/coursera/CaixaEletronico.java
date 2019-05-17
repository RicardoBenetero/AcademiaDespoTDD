package br.coursera;

import java.util.ArrayList;
import java.util.List;

public class CaixaEletronico {
	private ContaCorrente contaCorrenteRecuperada;

	List<ContaCorrente> contas = new ArrayList<ContaCorrente>();

	public String login(String numeroConta, Hardware hardware) {

		hardware.pegarNumeroDaContaCartao(numeroConta);

		return "Usuario autenticado";

	}

	public void depositar(String numeroContaCorrente, ServicoRemoto servicoRemoto, Hardware hardware, double saldo,
			boolean leituraEnvelope) {
		contaCorrenteRecuperada = servicoRemoto.recuperarConta(numeroContaCorrente);

		if (contaCorrenteRecuperada != null && leituraEnvelope == true) {
			servicoRemoto.persistirConta(contaCorrenteRecuperada.getNumeroConta(), saldo);

			//return hardware.lerEnvelope();
			hardware.lerEnvelope();
		}else {

		throw new LerEnvelopeException("Envelope com problema nao foi possivel receber");
		}
	}

	public void sacar(String numeroContaCorrente, ServicoRemoto servicoRemoto, Hardware hardware, double valor) {
		contaCorrenteRecuperada = servicoRemoto.recuperarConta(numeroContaCorrente);
		if ((contaCorrenteRecuperada.getSaldo() - valor) >= 0) {
			servicoRemoto.persistirConta(contaCorrenteRecuperada.getNumeroConta(), contaCorrenteRecuperada.getSaldo() - valor);

			hardware.entregarDinheiro();

		}else {

		throw new SaldoInsuficienteException("Saldo insuficiente");
		}
	}

	public String saldo(String numeroContaCorrente, ServicoRemoto servicoRemoto) {
		contaCorrenteRecuperada = servicoRemoto.recuperarConta(numeroContaCorrente);

		return "O saldo é R$" + contaCorrenteRecuperada.getSaldo();

	}
}
