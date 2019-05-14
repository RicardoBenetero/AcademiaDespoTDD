package br.coursera;

import br.coursera.testes.MockServicoRemoto;

public class CaixaEletronico {

	public String login(String numeroconta,MockServicoRemoto mock ) {
		
		if(mock.recuperarConta(numeroconta).getNumeroConta().contains(numeroconta)) {
		return "Usuário Autenticado";
	}else {
		return "Não foi possível autenticar o usuário";
	}

}
}
