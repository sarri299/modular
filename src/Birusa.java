
public class Birusa extends Karta {
	private String kolorea;
	private boolean komodin;
	
	public Birusa (String pKolorea,boolean pKomodin) {
		this.kolorea=pKolorea;
		this.komodin=pKomodin;
	}
	public void inprimatu() {
		System.out.println("Birus "+ this.kolorea);
	}
}
