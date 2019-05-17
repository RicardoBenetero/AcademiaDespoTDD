package br.coursera.testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.coursera.CaixaEletronico;
import br.coursera.ContaCorrente;
import br.coursera.ContaInexistenteException;
import br.coursera.LerEnvelopeException;
import br.coursera.NumeroContaException;
import br.coursera.SaldoInsuficienteException;

public class TesteCaixaEletronico {

	private CaixaEletronico atm;
	private List<ContaCorrente> contas;
	private MockServicoRemoto mock;
	private MockHardware mockHardware;
	private ContaCorrente conta1;
	private ContaCorrente conta2;
	private boolean leituraEnvelope = true;

	@Before
	public void inicializaDados() {

		atm = new CaixaEletronico();
		contas = new ArrayList<ContaCorrente>();
		conta1 = new ContaCorrente("1234");
		conta2 = new ContaCorrente("5678");
		contas.add(conta1);
		contas.add(conta2);
		mock = new MockServicoRemoto(contas);
		mockHardware = new MockHardware(contas);
	}

	@Test
	public void logarComSucesso() {

		assertEquals("Usuario autenticado", atm.login("1234", mockHardware));
	}

	@Test
	public void logarComSucessoCaixaComVariasContas() {

		assertEquals("Usuario autenticado", atm.login("5678", mockHardware));
	}

	@Test(expected = NumeroContaException.class)
	public void logarComFalha() {
		atm.login("78910", mockHardware);

	}

	@Test
	public void depositarComSucesso() {

		assertEquals("Deposito recebido com sucesso", atm.depositar("1234", mock, mockHardware, 200, leituraEnvelope));
	}

	@Test(expected = LerEnvelopeException.class)
	public void depositarComFalhaErroAoLerEnvelope() {
		leituraEnvelope = false;
		atm.depositar("1234", mock, mockHardware, 200, leituraEnvelope);

		
	}

	@Test(expected = ContaInexistenteException.class)
	public void depositarComFalha() {

		atm.depositar("888888", mock, mockHardware, 1236, leituraEnvelope);

	}

	@Test
	public void sacarComSucesso() {
		atm.depositar("1234", mock, mockHardware, 200, leituraEnvelope);
		atm.sacar("1234", mock, mockHardware, 100);

		assertEquals("O saldo é R$100.0",  atm.saldo("1234", mock));
		 
	}
	@Test
	public void chamarHardwareEntregarDinheiroComSucesso() {
		atm.depositar("1234", mock, mockHardware, 200, leituraEnvelope);
		atm.sacar("1234", mock, mockHardware, 100);

		assertTrue(mockHardware.entregarDinheiro);
		 
	}
	

	@Test(expected = ContaInexistenteException.class)
	public void sacarComFalha() {

		atm.sacar("888888", mock, mockHardware, 1236);

	}

	@Test(expected = SaldoInsuficienteException.class)
	public void sacarComFalhaSaldoInsuficiente() {
		ContaCorrente conta4 = new ContaCorrente("7777");
		contas.add(conta4);
		mock = new MockServicoRemoto(contas);
		atm.depositar("7777", mock, mockHardware, 200, leituraEnvelope);
		atm.sacar("7777", mock, mockHardware, 300);

	}

	@Test
	public void saldoComSucesso() {
		ContaCorrente conta3 = new ContaCorrente("6666");
		contas.add(conta3);
		mock = new MockServicoRemoto(contas);
		atm.depositar("6666", mock, mockHardware, 200, leituraEnvelope);
		atm.sacar("6666", mock, mockHardware, 100);
		assertEquals("O saldo é R$100.0", atm.saldo("6666", mock));
	}

}
