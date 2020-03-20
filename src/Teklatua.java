import java.util.Scanner;
public class Teklatua {
	private static Teklatua nireTeklatua=null;
	
	private Teklatua() {
	}
	
	public Teklatua getNireTeklatua() {
		if (nireTeklatua==null) {
			nireTeklatua= new Teklatua();
			
		}
		return nireTeklatua;
	}
	
}
