package br.coursera.academia.despo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

		MockPlacar mockPlacar = new MockPlacar(armazenamento);

		mockPlacar.registrarPonto(joao, 10, "estrela");
		mockPlacar.registrarPonto(marlene, 25, "moeda");

		assertEquals(10, joao.getPontos("estrela"));
		assertEquals(25, marlene.getPontos("moeda"));

	}
	@Test
	public void retornarTodosOsPontosDoUsuario() {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		Usuario joao = new Usuario("Joao");

		usuarios.add(joao);
		

		Armazenamento armazenamento = new Armazenamento(usuarios);

		MockPlacar mockPlacar = new MockPlacar(armazenamento);

		
		mockPlacar.registrarPonto(joao, 25, "moeda");
		mockPlacar.registrarPonto(joao, 50, "estrela");
		
        Map<String, Integer> tipos = new HashMap<String, Integer>();
		
		tipos.put("moeda", 25);
		tipos.put("estrela", 50);
		

		assertEquals(tipos, mockPlacar.retornarTodosPontosDoUsuario(joao));
	

	}
	@Test
	public void retornarRankingDeUmTipoDeponto() {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		Usuario joao = new Usuario("Joao");
		Usuario maria = new Usuario("Maria");
		Usuario ana = new Usuario("Ana");
		Usuario lucia = new Usuario("Lucia");

		usuarios.add(joao);
	    usuarios.add(maria);
		usuarios.add(ana);
		usuarios.add(lucia);

		

		Armazenamento armazenamento = new Armazenamento(usuarios);

		MockPlacar mockPlacar = new MockPlacar(armazenamento);

		
		mockPlacar.registrarPonto(joao, 25, "moeda");
		mockPlacar.registrarPonto(joao, 50, "estrela");
		mockPlacar.registrarPonto(maria, 5, "estrela");
		mockPlacar.registrarPonto(ana, 15, "estrela");
		mockPlacar.registrarPonto(ana, 10, "moeda");
		mockPlacar.registrarPonto(lucia, 10, "topico");

		

		assertEquals("Joao", 50, mockPlacar.retornarRankingDeUmTipoDeponto("estrela"));
	

	}

}
