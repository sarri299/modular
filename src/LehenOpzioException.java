
public class LehenOpzioException extends Exception{
	
	private String testua= "Mota Okerra, sartu 1 edo 2 zenbakiak:";
			
	public LehenOpzioException (){
		super ();
	}
	
	public void inprimatu(){
		System.out.println(this.testua);
	}
}
