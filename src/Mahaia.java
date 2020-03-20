import java.util.ArrayList;

public class Mahaia {
	private ListaKartak [] mahaia;
	
	public Mahaia() {
		this.mahaia=new ListaKartak [4];
		for (int i=0;i<4;i++) {
			this.mahaia[i]=new ListaKartak();
		}
	}
	public ListaKartak[] getMahaia() {
		return this.mahaia;
	}
}
