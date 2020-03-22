import java.util.Scanner;
public class Teklatua {
	private static Teklatua nireTeklatua=null;
	private Scanner sc;
	
	private Teklatua() {
		this.sc=new Scanner(System.in);
	}
	
	public static synchronized Teklatua getNireTeklatua() {
		if (nireTeklatua==null) {
			nireTeklatua= new Teklatua();
		}
		return nireTeklatua;
	}
	
	private boolean zenbakiaDa(String pHitza){
	    try{
	          Integer.parseInt(pHitza);
	          return true;
	    }
	    catch(NumberFormatException ex){
	        return false;
	    } 
	}
	
	public String irakurriHitz(){
		String sar=this.sc.nextLine();	
		boolean emaitza=this.zenbakiaDa(sar);
		if(emaitza==true){
			int zenbaki=Integer.parseInt(sar);
			String hitz=Integer.toString(zenbaki);
			return hitz;
		}
		else{
			return sar;
		}
	}
	
	public int irakurriHiruOpzioak() throws NumberFormatException, HiruOpzioException{
		String sar=this.sc.nextLine();
		int zenbaki=Integer.parseInt(sar);
		if(zenbaki<1 || zenbaki >2) {
			throw new HiruOpzioException();
		}
		return zenbaki;
	}

}


