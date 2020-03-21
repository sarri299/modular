
public class BigarrenOpzioException extends Exception{
	
	private String testua= "Mota Okerra, sartu 1,2 edo 3 zenbakiak:";
			
	public BigarrenOpzioException (){
		super ();
	}
	
	public void inprimatu(){
		System.out.println(this.testua);
	}
}
