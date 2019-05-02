
public class Pilha {

	public int tamanho;
	private Object[] elementos;
	private int quantidade = 0;

	public Pilha(int maximo) {
		elementos = new Object[maximo];
	}

	public boolean estaVazia() {
		return quantidade == 0;
	}

	public int tamanho() {
		return quantidade;
	}

	public void empilha(Object elemento) {
		
		if(quantidade == elementos.length)
			throw new PilhaCheiaException("Pilha est· cheia, n„o e possivel empilhar mais");
		this.elementos[quantidade] = elemento;
		quantidade++;
	}

	public Object topo() {

		return elementos[quantidade - 1];
	}

	public Object desempilha() {
		
		if(estaVazia())
			throw new PilhaVaziaException("n√£o √© poss√≠vel desempilhar");
		Object topo = topo();
		quantidade--;

		return topo;
	}

}
