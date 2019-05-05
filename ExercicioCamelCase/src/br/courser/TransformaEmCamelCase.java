package br.courser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TransformaEmCamelCase {

	public static List<String> converterCamelCase(String original) {

		List<String> listaPalavras;

		listaPalavras = retornaLista(original);

	    System.out.println(listaPalavras.get(0));
		return listaPalavras;

	}

	private static List<String> retornaLista(String original) {
		List<String> listaPalavras;

		
			listaPalavras = (Arrays.asList(original.split("(?=\\p{Upper})|(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)")));
		

		return listaPalavras;
	}

}
