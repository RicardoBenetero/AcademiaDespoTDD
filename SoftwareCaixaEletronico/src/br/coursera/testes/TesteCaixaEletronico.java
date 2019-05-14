package br.coursera.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.coursera.CaixaEletronico;

public class TesteCaixaEletronico {

	@Test
	public void logarComSucesso() {
		CaixaEletronico atm = new CaixaEletronico();
		MockServicoRemoto mock = new MockServicoRemoto();
		
		assertEquals( "Usuário Autenticado", atm.login("1234",mock));
	}

}
