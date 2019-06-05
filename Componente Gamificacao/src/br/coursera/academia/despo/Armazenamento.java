package br.coursera.academia.despo;

import java.util.ArrayList;

public class Armazenamento {

	ArrayList<Usuario> usuarios;

	public Armazenamento(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;

	}

	public void adicionarUsuario(Usuario usuario) {
		usuarios.add(usuario);

	}

	public void adicionarPonto(Usuario usuario, int ponto, String tipo) {

		usuario.adicionaPonto(ponto, tipo);

	}
	public int getQuantidadeTipo(Usuario usuario, String tipo) {
		return usuario.getPontos(tipo);
}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	

	

}
