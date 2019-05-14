package br.coursera.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.coursera.CaixaEletronico;

public class TesteCaixaEletronico {

	@Test
	public void logarComSucesso() {
		CaixaEletronico atm = new CaixaEletronico();
		MockServicoRemoto mock = new MockServicoRemoto();
		
		assertEquals( "Usu�rio Autenticado", atm.login("1234",mock));
	}

}
