
public class Jokoa {
	private static Jokoa nireJokoa=null;
	private int lehenAukera;
	private int bigarrenAukera;
	private int txanda;
	private boolean txandaAmaitu=false;
	private boolean jokoaAmaitu=false;

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
		
		
		
		
		while(!jokoaAmaitu) {
		
		if(this.txanda==1) {
			
			System.out.println(jokalari1.getIzena()+"-ren txanda");
			
			boolean ktrlpean;
			
			System.out.println("Zure kartak:");
			jokalari1.inprimatuEskua();
			System.out.println("");
			System.out.println("1-->Zure lehen karta erabili      2->Zure bigarren karta erabili      3->Zure hirugarren karta erabili");
			ktrlpean=false;
			do{
				try{
					this.lehenAukera=teklatua.irakurriHiruOpzioak();
					ktrlpean=true;
				}
				
				catch (NumberFormatException e){
					System.out.println("Ez duzu zenbaki bat sartu");
				}
				
				catch (HiruOpzioException e){
					e.inprimatu();
				}
			} while (ktrlpean==false);		
			ktrlpean=false;
			/*-------------------------------------------------------------------------------------------------------------------------------------*/
			while(!this.txandaAmaitu) {
				if((jokalari1.lortuKartaPosizioarekin(this.lehenAukera) instanceof Organoak)){
					if(!jokalari1.organoaJadaMahaian((Organoak)jokalari1.lortuKartaPosizioarekin(this.lehenAukera))) {
						jokalari1.mahaiaAktualizatu((Organoak)jokalari1.lortuKartaPosizioarekin(this.lehenAukera));
						if(this.txanda==4) {
							this.txanda=1;
						}
						else {
							this.txanda++;
						}
						this.txandaAmaitu=true;
						
						if(jokalari1.organoGuztiakOsasuntsu()) {
							this.jokoaAmaitu=true;
							System.out.println("Zorionak "+jokalari1.getIzena()+" irabazi egin duzu");
						}
					}
					else {
						System.out.println("Organoa jada zure mahailan dago");
						System.out.println("Hartu "+this.lehenAukera+" ez den beste karta bat");
						jokalari1.inprimatuEskua();
						System.out.println("");
						System.out.println("1-->Zure lehen karta erabili      2->Zure bigarren karta erabili      3->Zure hirugarren karta erabili");
							
						do{
							try{
								this.lehenAukera=teklatua.irakurriHiruOpzioak();
								ktrlpean=true;
							}
							
							catch (NumberFormatException e){
								System.out.println("Ez duzu zenbaki bat sartu");
							}
							
							catch (HiruOpzioException e){
								e.inprimatu();
							}
						} while (ktrlpean==false);		
						ktrlpean=false;
							
						if(jokalari1.lortuKartaPosizioarekin(this.lehenAukera) instanceof Botika) {
							if(jokalari1.koloreBerdinekoOrganoaDago((Botika)jokalari1.lortuKartaPosizioarekin(this.lehenAukera)) && !jokalari1.koloreBerdinekoOrganoaLortu((Botika)jokalari1.lortuKartaPosizioarekin(this.lehenAukera)).guztizBakunatuta()) {
								jokalari1.koloreBerdinekoOrganoaLortu((Botika)jokalari1.lortuKartaPosizioarekin(this.lehenAukera)).bakunaKopHanditu();
			
								if(this.txanda==4) {
									this.txanda=1;
								}										
								else {
									this.txanda++;
								}
								this.txandaAmaitu=true;
								
								if(jokalari1.organoGuztiakOsasuntsu()) {
									this.jokoaAmaitu=true;
									System.out.println("Zorionak "+jokalari1.getIzena()+" irabazi egin duzu");
								}
							}
							else {
								
								if(!jokalari1.koloreBerdinekoOrganoaDago((Botika)jokalari1.lortuKartaPosizioarekin(this.lehenAukera))) {
									System.out.println("Ez dago kolore berdineko organorik");
								}
								else if(!jokalari1.koloreBerdinekoOrganoaLortu((Botika)jokalari1.lortuKartaPosizioarekin(this.lehenAukera)).guztizBakunatuta()) {
									System.out.println("Organoa jada guztiz bakunatuta dago");
								}
								
								System.out.println("Hartu "+this.lehenAukera+" ez den beste karta bat");
								jokalari1.inprimatuEskua();
								System.out.println("");
								System.out.println("1-->Zure lehen karta erabili      2->Zure bigarren karta erabili      3->Zure hirugarren karta erabili");
										
								do{
										try{
											this.lehenAukera=teklatua.irakurriHiruOpzioak();
											ktrlpean=true;
										}
										
										catch (NumberFormatException e){
											System.out.println("Ez duzu zenbaki bat sartu");
										}
										
										catch (HiruOpzioException e){
											e.inprimatu();
										}
									} while (ktrlpean==false);		
									ktrlpean=false;
									
									if(jokalari1.lortuKartaPosizioarekin(this.lehenAukera) instanceof Birusa) {
										System.out.println("Zein jokalariari bidali nahi diozu birusa?");
										jokalari2.inprimatuEskua();
										jokalari3.inprimatuEskua();
										jokalari4.inprimatuEskua();
										System.out.println("");
										System.out.println("2->Bigarren Jokalariari      3->Hirugarren jokalariari      4->Laugarren jokalariari");
												
										do{
												try{
													this.bigarrenAukera=teklatua.irakurriHiruOpzioak();
													ktrlpean=true;
												}
												
												catch (NumberFormatException e){
													System.out.println("Ez duzu zenbaki bat sartu");
												}
												
												catch (HiruOpzioException e){
													e.inprimatu();
												}
											} while (ktrlpean==false);		
											ktrlpean=false;
											
									if(this.bigarrenAukera==2) {
										if(jokalari2.koloreBerdinekoOrganoaDago(jokalari1.lortuKartaPosizioarekin(this.lehenAukera))){
											if(!jokalari2.koloreBerdinekoOrganoaLortu((Birusa)jokalari1.lortuKartaPosizioarekin(this.lehenAukera))) {
												jokalari2.koloreBerdinekoOrganoaLortu((Birusa)jokalari1.lortuKartaPosizioarekin(this.lehenAukera)).birusKopHanditu();
											
											if(this.txanda==4) {
												this.txanda=1;
											}										
											else {
												this.txanda++;
											}
											this.txandaAmaitu=true;
											
											if(jokalari1.organoGuztiakOsasuntsu()) {
												this.jokoaAmaitu=true;
												System.out.println("Zorionak "+jokalari1.getIzena()+" irabazi egin duzu");
											}
										}
									}
									}
							}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			else if(jokalari1.lortuKartaPosizioarekin(this.lehenAukera) instanceof Botika){
				if(jokalari1.koloreBerdinekoOrganoaDago((Botika)jokalari1.lortuKartaPosizioarekin(this.lehenAukera))) {
					if(!jokalari1.koloreBerdinekoOrganoaLortu((Botika)jokalari1.lortuKartaPosizioarekin(this.lehenAukera)).guztizBakunatuta()) {
						jokalari1.koloreBerdinekoOrganoaLortu((Botika)jokalari1.lortuKartaPosizioarekin(this.lehenAukera)).bakunaKopHanditu();			
						
						if(this.txanda==4) {
							this.txanda=1;
						}
						else {
							this.txanda++;
						}
						this.txandaAmaitu=true;
						
						if(jokalari1.organoGuztiakOsasuntsu()) {
							this.jokoaAmaitu=true;
							System.out.println("Zorionak "+jokalari1.getIzena()+" irabazi egin duzu");
						}
					}
				}
				
				else {
					System.out.println("Ez dago kolore berdina duen organorik zure mahaian");
				}
			}
					
		}
	}	
}

