
import java.util.Random;

public class Randoma {

	//atributuak
	
	private static Randoma nireRandom;
	
	private Randoma (){
	}
	
	public static synchronized Randoma getNireRandoma(){
		if(Randoma.nireRandom == null){
    		Randoma.nireRandom = new Randoma();
    	}
    	return Randoma.nireRandom;
    }
	
	public int ausazkoa(int pZenbakia){
		Random zenbakiRandomak=new Random();
		int balioa=zenbakiRandomak.nextInt(pZenbakia)+1;
		return balioa;
	}
	
}
	