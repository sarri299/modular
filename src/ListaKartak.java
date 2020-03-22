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
	public void birusaGehitu(Birusa pBirusa) {
		Organoak organoa=(Organoak)kartaBat;
		organoa.birusKopHanditu();
	}
	public boolean organoGuztiakOsasuntsu() {
		Iterator<Karta> itr=this.getIteradorea();
		Karta kartaBat=null;
		boolean osasuntsu=true;
		Organoak organoa;
		while(itr.hasNext() && osasuntsu) {
			kartaBat=itr.next();
			if(kartaBat instanceof Organoak) {
				organoa=(Organoak)kartaBat;
				if(!organoa.osasuntsu()) {
					osasuntsu=false;
				}
			}
		}
		return osasuntsu;
	}
	public Organoak koloreBerdinekoOrganoaLortu(Karta pKarta) {
		Iterator<Karta> itr=this.getIteradorea();
		Karta kartaBat=null;
		boolean aurkitua=false;
		while(itr.hasNext() && !aurkitua) {
			kartaBat=itr.next();
			if(kartaBat instanceof Organoak) {
				if(kartaBat.koloreBerdina(pKarta)) {
					aurkitua=true;
				}
			}
		}
		if(!aurkitua) {
			System.out.println("Ez dago kolore berdineko organorik");
			kartaBat=null;
		}
		return (Organoak)kartaBat;
	}
	public boolean koloreBerdinekoOrganoaDago(Karta pKarta) {
		Iterator<Karta> itr=this.getIteradorea();
		Karta kartaBat=null;
		boolean aurkitua=false;
		while(itr.hasNext() && !aurkitua) {
			kartaBat=itr.next();
			if(kartaBat instanceof Organoak) {
				if(kartaBat.koloreBerdina(pKarta)) {
					aurkitua=true;
				}
			}
		}
		return aurkitua;
	}
	public boolean organoaJadaDago(Organoak pOrganoa) {
		Iterator<Karta> itr=this.getIteradorea();
		Karta kartaBat=null;
		boolean aurkitua=false;
		while(itr.hasNext() && !aurkitua) {
			kartaBat=itr.next();
			if(kartaBat instanceof Organoak) {
				if(kartaBat.koloreBerdina(pOrganoa)) {
					aurkitua=true;
				}
			}
		}
		return aurkitua;
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
