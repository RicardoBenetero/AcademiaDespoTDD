package br.courser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransformaEmCamelCase {

	public static List<String> converterCamelCase(String original) {
		TransformaEmCamelCase converter = new TransformaEmCamelCase();
		List<String> listaPalavras = null;

		listaPalavras = converter.retornaLista(original);

		return listaPalavras;
	}

	private List<String> retornaLista(String original) {
		List<String> listaPalavras;

		listaPalavras = retornaListaDePalavras(
				Arrays.asList(original.split("(?=\\p{Upper})|(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)")));

		return listaPalavras;
	}

	private List<String> retornaListaDePalavras(List<String> listaPalavras) {
		if (this.verificaSeListaPossuiUmaPalavra(listaPalavras)) {
			this.converteParaMinusculoQuandoUmaPalavra(listaPalavras);
		}
		return listaPalavras;

	}

	private void converteParaMinusculoQuandoUmaPalavra(List<String> listaPalavras) {
		listaPalavras.set(0, listaPalavras.get(0).toLowerCase());

	}

	private boolean verificaSeListaPossuiUmaPalavra(List<String> listaPalavras) {
		return (listaPalavras.size() == 1);
	}

}
