package birus;

public class Organoak extends Karta {
	private boolean komodin;
	private int bakunaKop;
	private int birusKop;
	
	public Organoak (String pKolorea,boolean pKomodin,int pBakunaKop) {
		super(pKolorea);
		this.kolorea=pKolorea;
		this.komodin=pKomodin;
		this.bakunaKop=pBakunaKop;
	}
	public void inprimatu() {
		System.out.println("Organo "+ super.kolorea);
	}
	public boolean guztizBakunatuta() {
		boolean emaitza=false;
		if(this.bakunaKop==2) {
			emaitza=true;
		}
		return emaitza;
	}
	public boolean guztizInfektatuta() {
		boolean emaitza=false;
		if(this.birusKop==2) {
			emaitza=true;
		}
		return emaitza;
	}
	public void bakunaKopHanditu() {
		if(this.bakunaKop<2) {
			this.bakunaKop++;
		}
	}
	public void birusKopHanditu() {
		if(this.birusKop<2) {
			this.birusKop++;
		}
	}
	public boolean osasuntsu() {
		boolean emaitza=false;
		if(this.birusKop==0) {
			emaitza=true;
		}
		return emaitza;
	}
}
