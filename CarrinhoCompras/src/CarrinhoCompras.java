import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
	private List<ObservadorCarrinho> observadores = new ArrayList<>();
	
	private List<Produto>	itens = new ArrayList();
	
	public void adicionaProduto(Produto p) {
		
		
		itens.add(p);
		for (ObservadorCarrinho observador : observadores)
		try {
			
			observador.produtoAdicionado(p.getNome(), p.getValor());
		} catch (Exception e) {
			
			
		}
	}
	
	public int total() {
		int total = 0;
		for (Produto p : itens) 
			total += p.getValor();
			return total;
		}

	public void adicionarObservador(ObservadorCarrinho observador) {
     observadores.add(observador);		
	}
	}


