package br.coursera.academia.despo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Arquivo {
	private ArrayList<Usuario> usuarios;

	public Arquivo(ArrayList<Usuario> usuarios) {

		this.usuarios = usuarios;

	}

	public void GravarArquivo(String nomeArquivo) throws IOException {
		FileWriter fw = new FileWriter(nomeArquivo);
		PrintWriter pw = new PrintWriter(fw);

		pw.println("Pontuação:\r\n");
		pw.printf("\tUsuario \t   Tipo \t pontos\r\n");
		pw.println("-----------------------------------------------------");
		for (Usuario usuario : usuarios) {
			getUsuarioTipos(pw, usuario);
		}
		pw.println("-----------------------------------------------------");
		fw.close();

	}

	public void getUsuarioTipos(PrintWriter pw, Usuario usuario) {
		String string = usuario.getTipos();
		String[] nomes = string.split(";");
		for (String nome : nomes) {
			pw.printf("%15s %15s %15d\r\n", usuario.getNome(), nome, usuario.getPontos(nome));

		}
	}
}
