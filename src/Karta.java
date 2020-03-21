
public abstract class Karta {
	protected String kolorea;

	public Karta() {}
	protected void inprimatu() {}
	
	protected boolean koloreBerdina(Karta pKarta) {
		boolean emaitza=false;
		if(this.kolorea==pKarta.kolorea) {
			emaitza=true;
		}
		return emaitza;
	}
}
