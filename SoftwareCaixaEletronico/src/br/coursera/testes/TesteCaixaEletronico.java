package br.coursera.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.coursera.CaixaEletronico;

public class TesteCaixaEletronico {

	@Test
	public void logarComSucesso() {
		CaixaEletronico atm = new CaixaEletronico();
		
		assertEquals( "Usuário Autenticado", atm.login());
	}

}
