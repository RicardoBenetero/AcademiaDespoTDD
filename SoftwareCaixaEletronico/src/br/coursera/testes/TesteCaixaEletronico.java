package br.coursera.testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.coursera.CaixaEletronico;

public class TesteCaixaEletronico {

	@Test
	public void logarComSucesso() {
		CaixaEletronico atm = new CaixaEletronico();
		
		List<ContaCorrente> contas = new ArrayList<ContaCorrente>();
		
		ContaCorrente conta1 = new ContaCorrente("1234");
		
		contas.add(conta1);

		MockServicoRemoto mock = new MockServicoRemoto(contas);
		
		assertEquals( "Usuário Autenticado", atm.login("1234",mock));
	}
	
	@Test
	public void logarComSucessoCaixaComVariasContas() {
		CaixaEletronico atm = new CaixaEletronico();
		
		ContaCorrente conta1 = new ContaCorrente("1234");
		ContaCorrente conta2 = new ContaCorrente("5678");
		List<ContaCorrente> contas = new ArrayList<ContaCorrente>();
		contas.add(conta1);
		contas.add(conta2);

		MockServicoRemoto mock = new MockServicoRemoto(contas);
		
		assertEquals( "Usuário Autenticado", atm.login("5678",mock));
	}

}
