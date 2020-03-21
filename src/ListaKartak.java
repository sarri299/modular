import java.util.ArrayList;
import java.util.Iterator;

public class ListaKartak {
	private ArrayList <Karta> lista;
	
	public ListaKartak() {
		this.lista=new ArrayList <Karta>();
	}
	
	private Iterator<Karta> getIteradorea() {
		return this.lista.iterator();
	}
	
	public void kartaGehitu (Karta pKarta) {
		this.lista.add(pKarta);
	}
	
	public Karta kartaKendu(int pPos) {
		return this.lista.remove(pPos);
		
	}
	public ArrayList <Karta> getLista(){
		return this.lista;
	}
	public int getTamaina() {
		return this.lista.size();
	}
	public Karta getKarta (int i) {
		return this.lista.get(i);
	}
	public boolean organoaJadaDago(Organoak pOrganoa) {
		return this.lista.contains(pOrganoa);
	}
	public void inprimatuEskua() {
		Iterator<Karta> itr=this.getIteradorea();
		Karta kartaBat=null;
		while(itr.hasNext()) {
			kartaBat=itr.next();
			kartaBat.inprimatu();
		}
	}
}
