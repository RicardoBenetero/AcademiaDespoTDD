import static org.junit.Assert.*;

import org.junit.Test;

public class TesteTradutor {

	@Test
	public void tradutorSemPalavras() {
		
		Tradutor t = new Tradutor();
		
		assertTrue(t.estaVazio());
		
	}
	@Test
	public void umaTraducao() {
		
		Tradutor t = new Tradutor();
		t.adicionaTraducao("bom", "good");
		assertFalse(t.estaVazio());
		assertEquals("good",t.traduzir("bom"));
		
	}

}
