package br.coursera.academia.despo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Armazenamento {

	private ArrayList<Usuario> usuarios;
	private Arquivo arquivo;

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

	public void gravarArquivo(String nomeArquivo) throws IOException {
		arquivo = new Arquivo(usuarios);

		arquivo.GravarArquivo(nomeArquivo);

	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<String> lerArquivo(String nomeArquivo) throws IOException {
		arquivo = new Arquivo(usuarios);
		return arquivo.lerArquivo(nomeArquivo);
		
	}
}
