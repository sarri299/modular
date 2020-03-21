import java.util.ArrayList;
import java.util.Iterator;

public class ListaJokalariak {
	private static ListaJokalariak nireListaJokalariak=null;
	private ArrayList<Jokalaria> lista;
	
	private ListaJokalariak() {
		this.lista=new ArrayList<Jokalaria>();
	}
	public static ListaJokalariak getNireListaJokalariak() {
		if (nireListaJokalariak==null) {
			nireListaJokalariak=new ListaJokalariak();
		}
		return nireListaJokalariak;
	}
	private Iterator<Jokalaria> getIteradorea(){
		return this.lista.iterator();
	}
	
	public void gehituJokalariak(Jokalaria pJokalaria) {
		this.lista.add(pJokalaria);
	}
	
	public void kartakBanatu(ListaKartak pMazoa) {
		Iterator<Jokalaria> itr=this.getIteradorea();
		Jokalaria jokalariBat=null;
		int i=0;
		while(itr.hasNext()) {
			jokalariBat=itr.next();
			while(i<3) {
				jokalariBat.kartaHartu(pMazoa.getKarta(i));
				i++;
			}
		}
	}
	public void partidaHasieratu() {
		Tableroa.getNiretableroa();
		Tableroa.getNiretableroa().kartakBanatu();
	}
	}
