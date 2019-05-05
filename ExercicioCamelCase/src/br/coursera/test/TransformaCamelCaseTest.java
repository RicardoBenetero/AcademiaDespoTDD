package br.coursera.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.courser.TransformaEmCamelCase;

public class TransformaCamelCaseTest {

	@Test
	public void dereraRetornarPalavrasEmMinusculoQuandoEntradaMinusculo() {
		List<String> resultadoEsperado = Arrays.asList("nome");
		
		String entrada = "nome";
		
		TransformaEmCamelCase palavraTranformada = new TransformaEmCamelCase();
		
		 assertEquals(resultadoEsperado, palavraTranformada.converterCamelCase(entrada));
		
	}

}

