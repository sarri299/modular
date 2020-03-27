package birus;

public class Organoak extends Karta {
	private boolean komodin;
	private int bakunaKop;
	private int birusKop;
	
	public Organoak (String pKolorea,boolean pKomodin,int pBakunaKop,int pBirusKop) {
		super(pKolorea);
		this.komodin=pKomodin;
		this.bakunaKop=pBakunaKop;
		this.birusKop=pBirusKop;
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
	public boolean erdiInfektatuta() {
		boolean emaitza=false;
		if(this.birusKop==1) {
			emaitza=true;
		}
		return emaitza;
	}
	public boolean erdiBakunatuta() {
		boolean emaitza=false;
		if(this.bakunaKop==1) {
			emaitza=true;
		}
		return emaitza;
	}
	public void birusaKendu() {
		this.birusKop=0;
	}
	public void bakunaKendu() {
		this.bakunaKop=0;
	}
}
