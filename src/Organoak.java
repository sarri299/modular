
public class Organoak extends Karta {
	private String kolorea;
	private boolean komodin;
	private int bakunaKop;
	
	public Organoak (String pKolorea,boolean pKomodin,int pBakunaKop) {
		this.kolorea=pKolorea;
		this.komodin=pKomodin;
		this.bakunaKop=pBakunaKop;
	}
	public void inprimatu() {
		System.out.println("Organo "+ this.kolorea);
	}
}
