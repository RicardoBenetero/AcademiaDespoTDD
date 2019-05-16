package br.coursera.testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.coursera.CaixaEletronico;
import br.coursera.ContaInexistenteException;

public class TesteCaixaEletronico {

	CaixaEletronico atm;
	List<ContaCorrente> contas;
	MockServicoRemoto mock;
	ContaCorrente conta1;
	ContaCorrente conta2;
	


	@Before
	public void inicializaDados() {

		atm = new CaixaEletronico();
		contas = new ArrayList<ContaCorrente>();
		conta1 = new ContaCorrente("1234");
		conta2 = new ContaCorrente("5678");
		contas.add(conta1);
		contas.add(conta2);
		mock = new MockServicoRemoto(contas);

	}

	@Test
	public void logarComSucesso() {

		assertEquals("Usu�rio Autenticado", atm.login("1234", mock));
	}

	@Test
	public void logarComSucessoCaixaComVariasContas() {

		assertEquals("Usu�rio Autenticado", atm.login("5678", mock));
	}

	@Test(expected = ContaInexistenteException.class)
	public void logarComFalha() {
		atm.login("78910", mock);

		
	}

	@Test
	public void depositarComSucesso() {
		
		assertEquals("Dep�sito recebido com sucesso", atm.depositar("1234", mock, 200));
	}
	
	@Test(expected = ContaInexistenteException.class)
	public void depositarComFalha() {
		
		atm.depositar("888888", mock, 1236);

		
	}
	
	@Test
	public void sacarComSucesso() {
		atm.depositar("1234", mock, 200);
		
		assertEquals("Retire seu dinheiro", atm.sacar("1234", mock, 100));
	}
	@Test(expected = ContaInexistenteException.class)
	public void sacarComFalha() {
		
		atm.sacar("888888", mock, 1236);

		
	}
	@Test
	public void sacarComFalhaSaldoInsuficiente() {
		ContaCorrente conta4 = new ContaCorrente("7777");
		contas.add(conta4);
		mock = new MockServicoRemoto(contas);
		atm.depositar("7777", mock, 200);
		
		assertEquals("Saldo Insuficiente", atm.sacar("7777", mock, 300));
	}
	
	@Test
	public void saldoComSucesso() {
		ContaCorrente conta3 = new ContaCorrente("6666");
		contas.add(conta3);
		mock = new MockServicoRemoto(contas);
		atm.depositar("6666", mock, 200);
		atm.sacar("6666", mock, 100);
		assertEquals("O saldo é R$100.0", atm.saldo("6666", mock));
	}
	

}
