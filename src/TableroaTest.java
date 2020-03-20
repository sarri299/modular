import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TableroaTest {
	Tableroa t;

	@BeforeEach
	void setUp() throws Exception {
		t=Tableroa.getNiretableroa();
	}

	@AfterEach
	void tearDown() throws Exception {
		t=null;
	}

	@Test
	void testGetNiretableroa() {
		Tableroa.getNiretableroa();
		ListaJokalariak.getNireListaJokalariak();
		Tableroa.getNiretableroa().kartakBanatu();
		ListaJokalariak.getNireListaJokalariak().getLista()[0].getEskua().getKarta(0).inprimatu();
		
		
	}

}
