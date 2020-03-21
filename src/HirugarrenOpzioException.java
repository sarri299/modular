
public class HirugarrenOpzioException extends Exception{
	
	private String testua= "Mota Okerra, sartu 1,2,3 edo 4 zenbakiak:";
			
	public HirugarrenOpzioException (){
		super ();
	}
	
	public void inprimatu(){
		System.out.println(this.testua);
	}
}
