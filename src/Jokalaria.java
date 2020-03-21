
public class Jokalaria {
	private ListaKartak eskua;
	private ListaKartak mahaia;
	private int kartaKopuruMax=3;
	private String izena;
	
	public Jokalaria(String pIzena) {
		this.eskua=new ListaKartak();
		this.mahaia=new ListaKartak();	
		this.izena=pIzena;
	}
	public void kartaHartu(Karta pKarta) {
		this.eskua.kartaGehitu(pKarta);
	}
	public ListaKartak getEskua () {
		return this.eskua;
	}
	public String getIzena() {
		return this.izena;
	}
	public void mahaiaAktualizatu(Karta pKarta) {
		this.mahaia.kartaGehitu(pKarta);
	}
	public Karta lortuKartaPosizioarekin(int pPos) {
		return this.eskua.getKarta(pPos);
	}
	public void inprimatuEskua() {
		this.eskua.inprimatuEskua();
	}
	public boolean organoaJadaMahaian(Organoak pOrganoa) {
		return this.mahaia.organoaJadaDago(pOrganoa);
	}
}
