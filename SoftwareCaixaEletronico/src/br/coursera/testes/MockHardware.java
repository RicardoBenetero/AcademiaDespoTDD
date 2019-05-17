package br.coursera.testes;

import java.util.ArrayList;
import java.util.List;

import br.coursera.ContaCorrente;
import br.coursera.Hardware;
import br.coursera.NumeroContaException;

public class MockHardware implements Hardware {
	
	List<ContaCorrente> contas = new ArrayList<ContaCorrente>();

	public List<ContaCorrente> getContas() {
		return contas;
	}

	public MockHardware(List<ContaCorrente> contas) {

		this.contas = contas;

	}

	@Override
	public String pegarNumeroDaContaCartao(String numeroConta) {
		for (ContaCorrente contaCorrente : contas) {
			if (contaCorrente.getNumeroConta() == numeroConta) {
				return numeroConta;
			}
		}

		throw new NumeroContaException("Nao foi possivel autenticar o usuario");
	}


	@Override
	public String entregarDinheiro() {
		return "Retire seu dinheiro";

	}

	@Override
	public String lerEnvelope() {
		return "Deposito recebido com sucesso";
		

	}

}
