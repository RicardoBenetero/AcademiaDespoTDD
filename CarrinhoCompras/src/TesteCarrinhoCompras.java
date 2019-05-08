import static org.junit.Assert.*;

import org.junit.Test;

public class TesteCarrinhoCompras {

	@Test
	public void totalCarrinho() {
		
		CarrinhoCompras c = new CarrinhoCompras();
		c.adicionaProduto(new Produto("tenis",100));
		c.adicionaProduto(new Produto("camiseta",50));
		c.adicionaProduto(new Produto("bermuda",70));
		
		assertEquals(220,c.total());

		
		
	}
	
	@Test
	public void escutaAdicaoProduto() {
		
		CarrinhoCompras c = new CarrinhoCompras();
		MockObservadorCarrinho mock = new MockObservadorCarrinho();
		c.adicionarObservador(mock);
		c.adicionaProduto(new Produto("tenis",100));
		mock.verificaRecebimentoProduto("tenis",100);
		assertEquals(220,c.total());

		
		
	}


}
