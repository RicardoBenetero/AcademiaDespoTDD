package br.coursera.academia.despo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArmazenamentoTest {

	@Test
	public void deveraArmazenarPontoAumUsuario() {
		Usuario joao = new Usuario();
		Armazenamento armazenamento = new Armazenamento();
		
		armazenamento.adicionarUsuario(joao);
		armazenamento.adicionarPonto(joao,10);
		
		assertEquals(10,joao.getPontuacao());
	}

}
