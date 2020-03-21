
public class Jokoa {
	private static Jokoa nireJokoa=null;
	private int lehenAukera;
	private int bigarrenAukera;
	private int hirugarrenAukera;
	private int txanda;

	private Jokoa() {
	}

	public static synchronized Jokoa getNireJokoa() {
		if(nireJokoa==null) {
			nireJokoa=new Jokoa();
		}
		return nireJokoa;
	}
	
	private void jokoaHasieratu(){
		Teklatua teklatua=Teklatua.getNireTeklatua();
		Tableroa tableroa=Tableroa.getNiretableroa();
		ListaJokalariak lista=ListaJokalariak.getNireListaJokalariak();
		Randoma randoma=Randoma.getNireRandoma();
		tableroa.kartakBanatu();
		System.out.println("Sartu 1. jokalariaren izena");
		Jokalaria jokalari1= new Jokalaria(teklatua.irakurriHitz());
		System.out.println("Sartu 2. jokalariaren izena");
		Jokalaria jokalari2= new Jokalaria(teklatua.irakurriHitz());
		System.out.println("Sartu 3. jokalariaren izena");
		Jokalaria jokalari3= new Jokalaria(teklatua.irakurriHitz());
		System.out.println("Sartu 4. jokalariaren izena");
		Jokalaria jokalari4= new Jokalaria(teklatua.irakurriHitz());
		
		lista.gehituJokalariak(jokalari1);
		lista.gehituJokalariak(jokalari2);
		lista.gehituJokalariak(jokalari3);
		lista.gehituJokalariak(jokalari4);
		
		tableroa.kartakBanatu();
		
		this.txanda=randoma.ausazkoa(4);
		
		System.out.println("Zure kartak:");
		
		jokalari1.inprimatuEskua();
		
		System.out.println("");
		
		if(this.txanda==1) {
			
			System.out.println(jokalari1.getIzena()+"-ren txanda");
				
			System.out.println("1->Zure kartekin zerbait egin        2->Besteen kartekin zerbait egin");
		
			boolean ktrlpean=false;
			do{
				try{
					this.lehenAukera=teklatua.irakurriLehenOpzioak();
					ktrlpean=true;
				}
			
				catch (NumberFormatException e){
					System.out.println("Ez duzu zenbaki bat sartu");
				}
			
				catch (LehenOpzioException e){
					e.inprimatu();
				}
			} while (ktrlpean==false);		
		
			if(this.lehenAukera==1) {
				System.out.println("1-->Zure lehen karta erabili      2->Zure bigarren karta erabili      3->Zure hirugarren karta erabili");
				ktrlpean=false;
				do{
					try{
						this.bigarrenAukera=teklatua.irakurriBigarrenOpzioak();
						ktrlpean=true;
					}
				
					catch (NumberFormatException e){
						System.out.println("Ez duzu zenbaki bat sartu");
					}
				
					catch (BigarrenOpzioException e){
						e.inprimatu();
					}
				} while (ktrlpean==false);		
				ktrlpean=false;
				
				if((jokalari1.lortuKartaPosizioarekin(this.bigarrenAukera) instanceof Organoak) && !jokalari1.organoaJadaMahaian((Organoak)jokalari1.lortuKartaPosizioarekin(this.bigarrenAukera))) {
					jokalari1.mahaiaAktualizatu(jokalari1.lortuKartaPosizioarekin(this.bigarrenAukera));
				}
				else if((jokalari1.lortuKartaPosizioarekin(this.bigarrenAukera) instanceof Tratamenduak) &&  {
					
				}
	}	
}

