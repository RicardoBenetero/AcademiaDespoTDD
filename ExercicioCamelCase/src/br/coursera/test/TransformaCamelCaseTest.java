package br.coursera.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.courser.TransformaEmCamelCase;

public class TransformaCamelCaseTest {

	TransformaEmCamelCase palavraTranformada;

	@Before
	public void preparaTeste() {
		palavraTranformada = new TransformaEmCamelCase();
	}

	@Test
	public void deveraRetornarPalavraEmMinusculoQuandoEntradaMinusculo() {
		List<String> resultadoEsperado = Arrays.asList("teste");
		String entrada = "teste";
		assertEquals(resultadoEsperado, palavraTranformada.converterCamelCase(entrada));
	}

	@Test
	public void deveraRetornarPalavraEmMaiusculoQuandoEntradaMinusculo() {
		List<String> resultadoEsperado = Arrays.asList("nome");
		String entrada = "Nome";
		assertEquals(resultadoEsperado, palavraTranformada.converterCamelCase(entrada));
	}

	@Test
	public void deveraRetornarSeparadoComDuasPalavraInicioMinusculo() {
		List<String> resultadoEsperado = Arrays.asList("nome", "Composto");
		String entrada = "nomeComposto";
		assertEquals(resultadoEsperado, palavraTranformada.converterCamelCase(entrada));
	}

	@Test
	public void deveraRetornarSeparadoComDuasPalavraInicioMaiusculo() {
		List<String> resultadoEsperado = Arrays.asList("nome", "Composto");
		String entrada = "NomeComposto";

		assertEquals(resultadoEsperado, palavraTranformada.converterCamelCase(entrada));
	}

	@Test
	public void deveraRetornarQuandoUmaPalavraAcronimo() {
		List<String> resultadoEsperado = Arrays.asList("CPF");
		String entrada = "CPF";
		assertEquals(resultadoEsperado, palavraTranformada.converterCamelCase(entrada));
	}

	@Test
	public void deveraRetornarQuandoDuasPalavraSegundaAcronimo() {
		List<String> resultadoEsperado = Arrays.asList("numero", "CPF");
		String entrada = "numeroCPF";
		assertEquals(resultadoEsperado, palavraTranformada.converterCamelCase(entrada));
	}

	@Test
	public void deveraRetornarQuandoMaisDeDuasPalavraComAcronimoNoMeio() {
		List<String> resultadoEsperado = Arrays.asList("numero", "CPF", "Contribuinte");
		String entrada = "numeroCPFContribuinte";
		assertEquals(resultadoEsperado, palavraTranformada.converterCamelCase(entrada));
	}

	@Test
	public void deveraRetornarQuandoComDuasPalavraSegundaNumero() {
		List<String> resultadoEsperado = Arrays.asList("recupera", "10", "primeiros");
		String entrada = "recupera10primeiros";
		assertEquals(resultadoEsperado, palavraTranformada.converterCamelCase(entrada));
	}

	@Test(expected = InicioDigitoException.class)
	public void deveraRetornarExcecaoQuandoPalavraIniciaComDigito() {
		String entrada = "1vamosTestarCEP10AgoraCara";
		palavraTranformada.converterCamelCase(entrada);
	}
	@Test(expected=PossuiCaracterEspecialException.class)
	public void deveraRetornarExcecaoQuandoComCaracteresEspeciais(){
		 String entrada = "nome#Composto";

		 palavraTranformada.converterCamelCase(entrada);
}

}
