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
		if (this.isAcronimo(original)) {
			listaPalavras = new ArrayList<String>();
			listaPalavras.add(original);
		}else {
		listaPalavras = retornaListaDePalavras(
				Arrays.asList(original.split("(?=\\p{Upper})|(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)")));

	
	}
		return listaPalavras;

	}

	private boolean isAcronimo(String original) {
		
		return original.toUpperCase().equals(original);
	}

	private List<String> retornaListaDePalavras(List<String> listaPalavras) {
		if (this.verificaSeListaPossuiUmaPalavra(listaPalavras)) {
			this.converteParaMinusculoQuandoUmaPalavra(listaPalavras);
		} else {
			listaPalavras = this.trataListaPalavras(listaPalavras);
		}
		return listaPalavras;

	}

	private List<String> trataListaPalavras(List<String> listaPalavras) {
		List<String> novaListaPalavras = new ArrayList<String>();
		String montarAcronimo = new String();

		for (String palavra : listaPalavras) {
			montarAcronimo = this.incluirPalavra(novaListaPalavras, palavra, montarAcronimo);

		}

		return novaListaPalavras;
	}

	private void converteParaMinusculoQuandoUmaPalavra(List<String> listaPalavras) {
		listaPalavras.set(0, listaPalavras.get(0).toLowerCase());

	}

	private boolean verificaSeListaPossuiUmaPalavra(List<String> listaPalavras) {
		return (listaPalavras.size() == 1);
	}

	private void incluirPalavra(List<String> listaPalavras, String palavra) {
		if (listaPalavras.size() == 0)
			listaPalavras.add(palavra.toLowerCase());
		else
			listaPalavras.add(palavra);
	}

	private String incluirPalavra(List<String> listaPalavras, String palavra, String acronimo) {
		if (palavra.length() > 1) {

			this.incluirPalavra(listaPalavras, palavra);

		}

		return acronimo;
	}
}
