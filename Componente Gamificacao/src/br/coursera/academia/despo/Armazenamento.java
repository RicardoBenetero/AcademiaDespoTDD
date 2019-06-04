package br.coursera.academia.despo;

import java.util.ArrayList;

public class Armazenamento {
	
	ArrayList <Usuario> usuarios = new ArrayList<Usuario>();

	public void adicionarUsuario(Usuario usuario) {
		usuarios.add(usuario);
		
	}

	public void adicionarPonto(Usuario usuario,int ponto) {
		    
			usuario.adicionaPonto(ponto);
			
		}
		
	

	public Object getUsuario(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
