import java.util.ArrayList;

public class ListaJokalariak {
	private static ListaJokalariak nireListaJokalariak=null;
	private Jokalaria[] lista;
	private boolean amaitu;
	
	private ListaJokalariak() {
		this.lista=new Jokalaria[4];
		for(int i=0;i<4;i++) {
			this.lista[i]=new Jokalaria();
		}
		this.amaitu=false;
	}
	public static ListaJokalariak getNireListaJokalariak() {
		if (nireListaJokalariak==null) {
			nireListaJokalariak=new ListaJokalariak();
		}
		return nireListaJokalariak;
	}
	
	public void partidaHasieratu() {
		Tableroa.getNiretableroa();
		Tableroa.getNiretableroa().kartakBanatu();

	}
	
	public Jokalaria[] getLista() {
		return this.lista;
	}
	}
