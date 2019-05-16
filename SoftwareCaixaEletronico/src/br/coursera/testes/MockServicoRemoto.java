package br.coursera.testes;

import java.util.ArrayList;
import java.util.List;

import br.coursera.ContaInexistenteException;
import br.coursera.ServicoRemoto;

public class MockServicoRemoto implements ServicoRemoto {
	List<ContaCorrente> contas = new ArrayList<ContaCorrente>();

	public List<ContaCorrente> getContas() {
		return contas;
	}

	public MockServicoRemoto(List<ContaCorrente> contas) {

		this.contas = contas;

	}

	public ContaCorrente recuperarConta(String numeroConta) {
		for (ContaCorrente contaCorrente : contas) {
			if (contaCorrente.getNumeroConta() == numeroConta) {
				return contaCorrente;
			}
		}

		throw new ContaInexistenteException("N�o foi poss�vel autenticar o usu�rio");
	}

	@Override
	public void persistirConta(String numeroConta, Double saldo) {

		for (ContaCorrente contaCorrente : contas) {
			if (contaCorrente.getNumeroConta() == numeroConta) {

				contaCorrente.setSaldo(saldo);
			}

		}

	}
}
