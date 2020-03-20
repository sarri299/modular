
public class Jokalaria {
	private ListaKartak eskua;
	public Mahaia mahaia;
	public int kartaKopuruMax=3;
	
	public Jokalaria() {
		this.eskua=new ListaKartak();
		this.mahaia=new Mahaia();	
	}
	public void kartaHartu(Karta pKarta) {
		this.eskua.kartaGehitu(pKarta);
	}
	public ListaKartak getEskua () {
		return this.eskua;
	}
}
