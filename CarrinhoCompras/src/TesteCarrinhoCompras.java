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
		assertEquals(100,c.total());

		
		
	}
	@Test
	public void adicionarDoisObservadores() {
		
		CarrinhoCompras c = new CarrinhoCompras();
		MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
		MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
		c.adicionarObservador(mock1);
		c.adicionarObservador(mock2);
		c.adicionaProduto(new Produto("tenis",100));
		mock1.verificaRecebimentoProduto("tenis",100);
		mock2.verificaRecebimentoProduto("tenis",100);

		assertEquals(100,c.total());

		
		
	}
	
	@Test
	public void continuaNotificandoComErroEmObservador() {
		
		CarrinhoCompras c = new CarrinhoCompras();
		MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
		MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
		MockObservadorCarrinho mock3 = new MockObservadorCarrinho();

		mock2.queroQueVoceDePau();
		c.adicionarObservador(mock1);
		c.adicionarObservador(mock2);
		c.adicionarObservador(mock3);

		c.adicionaProduto(new Produto("tenis",100));
		mock1.verificaRecebimentoProduto("tenis",100);
		mock3.verificaRecebimentoProduto("tenis",100);

		assertEquals(100,c.total());

		
		
	}
	@Test
	public void continuaNotificandoComErroEmObservadorComMockObservadorProblema() {
		
		CarrinhoCompras c = new CarrinhoCompras();
		MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
		MockObservadorCarrinho mock3 = new MockObservadorCarrinho();

	    ObservadorCarrinho mock2 = new MockObservadorComProblema();
		c.adicionarObservador(mock1);
		c.adicionarObservador(mock2);
		c.adicionarObservador(mock3);

		c.adicionaProduto(new Produto("tenis",100));
		mock1.verificaRecebimentoProduto("tenis",100);
		mock3.verificaRecebimentoProduto("tenis",100);

		assertEquals(100,c.total());

		
		
	}

}
