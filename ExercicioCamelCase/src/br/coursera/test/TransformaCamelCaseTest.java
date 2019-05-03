package br.coursera.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.courser.TransformaEmCamelCase;

public class TransformaCamelCaseTest {

	@Test
	public void dereraRetornarPalavrasEmCamelCase() {
		
		TransformaEmCamelCase palavraTranformada = new TransformaEmCamelCase();
		
		String original = "nome";
		
		String resultadoEsperado = "nome";
		
		assertEquals(resultadoEsperado,palavraTranformada.transformaEmCamelCase(original));
		
	}

}

