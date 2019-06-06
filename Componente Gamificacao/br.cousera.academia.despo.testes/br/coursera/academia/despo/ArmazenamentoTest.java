package br.coursera.academia.despo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ArmazenamentoTest {

	@Test
	public void deveraArmazenarPontoAumUsuario() {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		Usuario joao = new Usuario("Joao");
		usuarios.add(joao);
		Armazenamento armazenamento = new Armazenamento(usuarios);
		
		armazenamento.armazenarQuantidadeTipoPontoRecebidaPorUsuario(joao,10,"estrela");
        Map<String, Integer> tipos = new HashMap<String, Integer>();
		
		tipos.put("estrela", 10);
		assertEquals(tipos,joao.getPontuacao());
	}
	@Test
	public void deveraArmazenarPontoAumUsuarioEtipoDoPonto() {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		Usuario joao = new Usuario("Joao");
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
		Usuario joao = new Usuario("Joao");
		usuarios.add(joao);
		Armazenamento armazenamento = new Armazenamento(usuarios);
		
		armazenamento.armazenarQuantidadeTipoPontoRecebidaPorUsuario(joao,10,"estrela");
		armazenamento.armazenarQuantidadeTipoPontoRecebidaPorUsuario(joao,20,"moeda");

		
		
		
		assertEquals(20,armazenamento.recuperarQuantosPontosDeUmTipoTemUsuario(joao, "moeda"));
	}
	@Test
	public void deveraRetornarUsuarioQueJaRecebeuAlgumTipoDePonto() {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		Usuario joao = new Usuario("Joao");
		Usuario maria = new Usuario("Maria");
		Usuario marlene = new Usuario("Marlene");


		usuarios.add(joao);
		usuarios.add(maria);
		usuarios.add(marlene);

		Armazenamento armazenamento = new Armazenamento(usuarios);
		
		armazenamento.armazenarQuantidadeTipoPontoRecebidaPorUsuario(joao,10,"estrela");
		armazenamento.armazenarQuantidadeTipoPontoRecebidaPorUsuario(maria,20,"moeda");

		
		
		
		
		assertEquals("Joao;Maria;",armazenamento.recuperarUsuarioQueJaRecebeuAlgumTipoDePonto());
	}
	@Test
	public void deveraRetornarTodosOsTiposDePontosRecebidosPeloUsuario() {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		Usuario joao = new Usuario("Joao");
		


		usuarios.add(joao);
		
		Armazenamento armazenamento = new Armazenamento(usuarios);
		
		armazenamento.armazenarQuantidadeTipoPontoRecebidaPorUsuario(joao,10,"estrela");
		armazenamento.armazenarQuantidadeTipoPontoRecebidaPorUsuario(joao,20,"moeda");
		armazenamento.armazenarQuantidadeTipoPontoRecebidaPorUsuario(joao,20,"topico");
		armazenamento.armazenarQuantidadeTipoPontoRecebidaPorUsuario(joao,20,"comentario");

		
		
		
		
		assertEquals("topico;moeda;estrela;comentario;",armazenamento.recuperarTodosOsTiposDePontosRecebidosPeloUsuario(joao));
	}
	@Test
	public void deveraGravarArquivoComPontuacaoDosUsuarios() throws IOException {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		Usuario joao = new Usuario("Joao");
		Usuario marlene = new Usuario("Marlene");



		usuarios.add(joao);
		usuarios.add(marlene);

		Armazenamento armazenamento = new Armazenamento(usuarios);
		
		armazenamento.armazenarQuantidadeTipoPontoRecebidaPorUsuario(joao,10,"estrela");
		armazenamento.armazenarQuantidadeTipoPontoRecebidaPorUsuario(joao,20,"moeda");
		armazenamento.armazenarQuantidadeTipoPontoRecebidaPorUsuario(marlene,20,"topico");
		armazenamento.armazenarQuantidadeTipoPontoRecebidaPorUsuario(marlene,20,"comentario");

		
		armazenamento.GravarArquivo("arquivo.txt");
		
		
	}

}
