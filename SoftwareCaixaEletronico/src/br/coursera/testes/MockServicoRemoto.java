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

	public String recuperarConta(String numeroConta) {
		for (ContaCorrente contaCorrente : contas) {
			if (contaCorrente.getNumeroConta() == numeroConta) {
				return contaCorrente.getNumeroConta();
			}
		}

		throw new ContaInexistenteException("Não foi possível autenticar o usuário");
	}

	@Override
	public void persistirConta(String numeroConta, Double saldo) {
		System.out.println(saldo + " saldo do persistir" );

		for (ContaCorrente contaCorrente : contas) {
			if (contaCorrente.getNumeroConta() == numeroConta) {
			
				System.out.println(contaCorrente.getNumeroConta() + "numeroconta " +contaCorrente.getSaldo() + " saldo" );
				contaCorrente.setSaldo(saldo);
			}


		
		
			
		}
		
	}
}
