package br.coursera;

public class ContaInexistenteException extends RuntimeException {
	public ContaInexistenteException (String msg) {
		super(msg);
	}
}
