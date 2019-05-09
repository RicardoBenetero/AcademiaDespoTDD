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
	public void dereraRetornarPalavraEmMinusculoQuandoEntradaMinusculo() {
		List<String> resultadoEsperado = Arrays.asList("teste");

		String entrada = "teste";

		assertEquals(resultadoEsperado, palavraTranformada.converterCamelCase(entrada));
	}

	@Test
	public void dereraRetornarPalavraEmMaiusculoQuandoEntradaMinusculo() {
		List<String> resultadoEsperado = Arrays.asList("nome");

		String entrada = "Nome";

		assertEquals(resultadoEsperado, palavraTranformada.converterCamelCase(entrada));
	}

	@Test
	public void dereraRetornarSeparadoComDuasPalavraInicioMinusculo() {
		List<String> resultadoEsperado = Arrays.asList("nome", "Composto");
		String entrada = "nomeComposto";
		assertEquals(resultadoEsperado, palavraTranformada.converterCamelCase(entrada));
	}
	@Test
	public void  dereraRetornarSeparadoComDuasPalavraInicioMaiusculo() {
		 List<String> resultadoEsperado = Arrays.asList("nome", "Composto");
		 String entrada = "NomeComposto";

		 assertEquals(resultadoEsperado, palavraTranformada.converterCamelCase(entrada));		 
}

}
