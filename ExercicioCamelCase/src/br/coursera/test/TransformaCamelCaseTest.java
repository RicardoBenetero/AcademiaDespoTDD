package br.coursera.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.courser.TransformaEmCamelCase;

public class TransformaCamelCaseTest {

	@Test
	public void dereraRetornarPalavraEmMinusculoQuandoEntradaMinusculo() {
		List<String> resultadoEsperado = Arrays.asList("teste");
		
		String entrada = "teste";
		
		TransformaEmCamelCase palavraTranformada = new TransformaEmCamelCase();
		
		 assertEquals(resultadoEsperado, palavraTranformada.converterCamelCase(entrada));
	}
	@Test
	public void dereraRetornarPalavraEmMaiusculoQuandoEntradaMinusculo() {
		List<String> resultadoEsperado = Arrays.asList("nome");
		
		String entrada = "Nome";
		
		TransformaEmCamelCase palavraTranformada = new TransformaEmCamelCase();
		
		 assertEquals(resultadoEsperado, palavraTranformada.converterCamelCase(entrada));
	}
	
	@Test
	public void dereraRetornarSeparadoComDuasPalavraInicioMinusculo() {
		TransformaEmCamelCase palavraTranformada = new TransformaEmCamelCase();
		 List<String> resultadoEsperado = Arrays.asList("nome", "Composto");
		 String entrada = "nomeComposto";
         System.out.println("teste duas palavras retorna separado "+ entrada); 
		 assertEquals(resultadoEsperado, palavraTranformada.converterCamelCase(entrada));
}

}

