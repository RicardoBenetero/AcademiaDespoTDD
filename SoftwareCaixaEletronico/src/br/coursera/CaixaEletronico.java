package br.coursera;

import br.coursera.testes.MockServicoRemoto;

public class CaixaEletronico {

	public String login(String numeroconta,MockServicoRemoto mock ) {
		
		if(mock.recuperarConta(numeroconta).getNumeroConta().contains(numeroconta)) {
		return "Usu�rio Autenticado";
	}else {
		return "N�o foi poss�vel autenticar o usu�rio";
	}

}
}
