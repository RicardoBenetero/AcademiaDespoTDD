package br.coursera.academia.despo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PlacarTest {

	@Test
	public void registrarPonto() {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		Usuario joao = new Usuario("Joao");
		Usuario marlene = new Usuario("Marlene");



		usuarios.add(joao);
		usuarios.add(marlene);

		Armazenamento armazenamento = new Armazenamento(usuarios);
		
		
		MockPlacar  mockPlacar = new MockPlacar(armazenamento);
		
		mockPlacar.registrarPonto(joao, 10, "estrela");
		mockPlacar.registrarPonto(joao, 5, "estrela");
		mockPlacar.registrarPonto(marlene, 15, "estrela");
		mockPlacar.registrarPonto(marlene, 25, "moeda");
	
		assertEquals(25,joao.getPontos("estrela"));
		assertEquals(15,marlene.getPontos("estrela"));

	}

}
