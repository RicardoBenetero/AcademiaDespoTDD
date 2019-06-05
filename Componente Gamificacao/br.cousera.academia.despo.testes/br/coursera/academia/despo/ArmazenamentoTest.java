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
		
		armazenamento.armazenarQuantidadeTipoPontoRecebidaPorUsuario(joao,10,"estrela");
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
		
		armazenamento.armazenarQuantidadeTipoPontoRecebidaPorUsuario(joao,10,"estrela");
		
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
		
		armazenamento.armazenarQuantidadeTipoPontoRecebidaPorUsuario(joao,10,"estrela");
		armazenamento.armazenarQuantidadeTipoPontoRecebidaPorUsuario(joao,20,"moeda");

		
		Map<String, Integer> tipos = new HashMap<String, Integer>();
		
		tipos.put("estrela", 10);
		tipos.put("moeda", 20);
		
		
		assertEquals(20,armazenamento.recuperarQuantosPontosDeUmTipoTemUsuario(joao, "moeda"));
	}
	@Test
	public void deveraRetornarUsuarioQueJaRecebeuAlgumTipoDePonto() {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		Usuario joao = new Usuario();
		Usuario maria = new Usuario();

		usuarios.add(joao);
		usuarios.add(maria);

		Armazenamento armazenamento = new Armazenamento(usuarios);
		
		armazenamento.armazenarQuantidadeTipoPontoRecebidaPorUsuario(joao,10,"estrela");
		armazenamento.armazenarQuantidadeTipoPontoRecebidaPorUsuario(joao,20,"moeda");

		
		
		
		
		assertEquals("joao",armazenamento.recuperarUsuarioQueJaRecebeuAlgumTipoDePonto());
	}


}
