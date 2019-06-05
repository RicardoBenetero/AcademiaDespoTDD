package br.coursera.academia.despo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ArmazenamentoTest {

	@Test
	public void deveraArmazenarPontoAumUsuario() {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		Usuario joao = new Usuario();
		usuarios.add(joao);
		Armazenamento armazenamento = new Armazenamento(usuarios);
		
		armazenamento.adicionarUsuario(joao);
		armazenamento.adicionarPonto(joao,10,"estrela");
        Map<String, Integer> tipos = new HashMap<String, Integer>();
		
		tipos.put("estrela", 10);
		assertEquals(tipos,joao.getPontuacao());
	}
	@Test
	public void deveraArmazenarPontoAumUsuarioeTipodoPonto() {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		Usuario joao = new Usuario();
		usuarios.add(joao);
		Armazenamento armazenamento = new Armazenamento(usuarios);
		
		armazenamento.adicionarUsuario(joao);
		armazenamento.adicionarPonto(joao,10,"estrela");
		
		Map<String, Integer> tipos = new HashMap<String, Integer>();
		
		tipos.put("estrela", 10);
		
		assertEquals(tipos,joao.getPontuacao());
	}
	@Test
	public void deveraRecuperarQuantosPontosDeUmTipoUsuarioTem() {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		Usuario joao = new Usuario();
		usuarios.add(joao);
		Armazenamento armazenamento = new Armazenamento(usuarios);
		
		armazenamento.adicionarUsuario(joao);
		armazenamento.adicionarPonto(joao,10,"estrela");
		armazenamento.adicionarPonto(joao,20,"moeda");
		armazenamento.adicionarPonto(joao,20,"moeda");

		
		Map<String, Integer> tipos = new HashMap<String, Integer>();
		
		tipos.put("estrela", 10);
		tipos.put("moeda", 20);
		
		
		assertEquals(10,armazenamento.getQuantidadeTipo(joao, "moeda"));
	}


}
