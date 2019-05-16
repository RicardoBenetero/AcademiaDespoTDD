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
		
		System.out.println(saldo + "  saldo no depositar");
		
		System.out.println(contaCorrenteRecuperada + "  contaCorrenteRecuperada no depositar");

		mock.persistirConta(contaCorrenteRecuperada, saldo);

		return "Depósito recebido com sucesso";

	}

	public String sacar(String numeroContaCorrente, MockServicoRemoto mock, double saldo) {
		contaCorrenteRecuperada = mock.recuperarConta(numeroContaCorrente);
		
		double saldoCom = mock.getContas().iterator().next().getSaldo();
		System.out.println(saldoCom + " saldoSemRetirada"   + "  " +contaCorrenteRecuperada);
		
		
		double saldoComRetirada = mock.getContas().iterator().next().getSaldo() - saldo;
		mock.persistirConta(contaCorrenteRecuperada, saldoComRetirada);
System.out.println(saldoComRetirada + " saldoComRetirada"   + "  " +contaCorrenteRecuperada);
		return "Retire seu dinheiro";
	}
}
