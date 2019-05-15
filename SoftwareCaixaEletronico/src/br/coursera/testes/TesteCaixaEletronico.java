package br.coursera.testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.coursera.CaixaEletronico;

public class TesteCaixaEletronico {

	CaixaEletronico atm;
	List<ContaCorrente> contas;
	MockServicoRemoto mock;
	ContaCorrente conta1;
	ContaCorrente conta2;

	@Before
	public void inicializaDados() {

		atm = new CaixaEletronico();
		contas = new ArrayList<ContaCorrente>();
		conta1 = new ContaCorrente("1234");
		conta2 = new ContaCorrente("5678");
		contas.add(conta1);
		contas.add(conta2);
		mock = new MockServicoRemoto(contas);

	}

	@Test
	public void logarComSucesso() {

		assertEquals("Usuário Autenticado", atm.login("1234", mock));
	}

	@Test
	public void logarComSucessoCaixaComVariasContas() {

		assertEquals("Usuário Autenticado", atm.login("5678", mock));
	}

	@Test
	public void logarComFalha() {

		assertEquals("Não foi possível autenticar o usuário", atm.login("78910", mock));
	}

	@Test
	public void depositarComSucesso() {

		assertEquals("Depósito recebido com sucesso", atm.depositar("1234", mock, 100));
	}

}
