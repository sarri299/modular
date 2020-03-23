package birus;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListaJokalariakTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPartidaHasieratu() {
		ListaJokalariak.getNireListaJokalariak().partidaHasieratu();
		System.out.print(ListaJokalariak.getNireListaJokalariak().getLista()[1].getEskua().getTamaina());
	}

}
