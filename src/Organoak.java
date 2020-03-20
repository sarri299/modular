
public class Organoak extends Karta {
	private String kolorea;
	private boolean komodin;
	
	public Organoak (String pKolorea,boolean pKomodin) {
		this.kolorea=pKolorea;
		this.komodin=pKomodin;
	}
	public void inprimatu() {
		System.out.println("Organo "+ this.kolorea);
	}
}
