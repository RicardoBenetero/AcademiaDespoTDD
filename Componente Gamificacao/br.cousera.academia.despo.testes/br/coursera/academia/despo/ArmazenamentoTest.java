package br.coursera.academia.despo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ArmazenamentoTest {

	@Test
	public void deveraArmazenarPontoAumUsuario() {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		Usuario joao = new Usuario();
		usuarios.add(joao);
		Armazenamento armazenamento = new Armazenamento(usuarios);
		
		armazenamento.adicionarUsuario(joao);
		armazenamento.adicionarPonto(joao,10);
		
		assertEquals(10,joao.getPontuacao());
	}

}
