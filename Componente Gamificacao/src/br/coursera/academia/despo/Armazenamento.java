package br.coursera.academia.despo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Armazenamento {

	ArrayList<Usuario> usuarios;

	public Armazenamento(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;

	}

	public void armazenarQuantidadeTipoPontoRecebidaPorUsuario(Usuario usuario, int quantidadePonto, String tipo) {

		usuario.adicionaPonto(quantidadePonto, tipo);

	}

	public int recuperarQuantosPontosDeUmTipoTemUsuario(Usuario usuario, String tipo) {
		return usuario.getPontos(tipo);
	}

	public String recuperarUsuarioQueJaRecebeuAlgumTipoDePonto() {
		String nomes = "";
		for (Usuario usurario : usuarios) {
			if (usurario.temAlgumTipoDePonto()) {
				nomes = nomes + usurario.getNome() + ";";
			}
		}
		return nomes;
	}

	public String recuperarTodosOsTiposDePontosRecebidosPeloUsuario(Usuario usuario) {
		
		return usuario.getTipos();
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
