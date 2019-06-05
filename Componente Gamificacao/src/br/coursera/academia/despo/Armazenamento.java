package br.coursera.academia.despo;

import java.util.ArrayList;
import java.util.Map;

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
}
