package br.coursera.academia.despo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Arquivo {
	private ArrayList<Usuario> usuarios;
	//private Armazenamento armazenamento;
	
	public Arquivo(ArrayList<Usuario> usuarios) {
		
		this.usuarios = usuarios;
		
	}
	
	public void GravarArquivo(String nomeArquivo) throws IOException {
		FileWriter fw = new FileWriter(nomeArquivo);
		PrintWriter pw = new PrintWriter(fw);

		pw.println("Pontuação:\r\n");
		pw.printf("\tUsuario \t   Tipo \t pontos\r\n");
		pw.println("-----------------------------------------------------");
		for(Usuario u : usuarios){
			getUsuarioTipos(pw, u);
		}
		pw.println("-----------------------------------------------------");
       fw.close();
		
	}
	public void getUsuarioTipos(PrintWriter pw, Usuario usuario){
		String s = usuario.getTipos();
		String[] nomes = s.split(";");
		for(String n : nomes){
			pw.printf("%15s %15s %15d\r\n", usuario.getNome(), n, usuario.getPontos(n));
			
		}
}
}
