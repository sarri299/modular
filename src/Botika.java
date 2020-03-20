
public class Botika extends Karta {
	private String kolorea;
	private boolean komodin;
	
	public Botika (String pKolorea,boolean pKomodin) {
		this.kolorea=pKolorea;
		this.komodin=pKomodin;
	}
	public void inprimatu() {
		System.out.println("Botika "+ this.kolorea);
	}
}