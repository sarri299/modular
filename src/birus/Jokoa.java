package birus;

public class Jokoa {
	private static Jokoa nireJokoa=null;
	private int lehenAukera=0;
	private int bigarrenAukera=0;
	private int txanda;
	private boolean txandaAmaitu=false;
	private boolean jokoaAmaitu=false;
	private boolean organoa=true;
	private boolean botika=true;
	private boolean birusa=true;

	private Jokoa() {
	}

	public static synchronized Jokoa getNireJokoa() {
		if(nireJokoa==null) {
			nireJokoa=new Jokoa();
		}
		return nireJokoa;
	}
	private void teklatuaKanpo(Jokalaria jokalari1,Jokalaria jokalari2,Jokalaria jokalari3,Jokalaria jokalari4) {
		Teklatua teklatua=Teklatua.getNireTeklatua();
		boolean ktrlpean=false;
		if(this.bigarrenAukera!=0) {
			System.out.println("Hartu "+this.bigarrenAukera+" ez den beste karta bat");
		}
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
	}
	private void teklatuaBarne(Jokalaria jokalari1) {
		Teklatua teklatua=Teklatua.getNireTeklatua();
		boolean ktrlpean=false;
		jokalari1.inprimatuEskua();
		System.out.println("");
		if(this.lehenAukera!=0) {
			System.out.println("Hartu "+this.lehenAukera+" ez den beste karta bat");
		}
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
	}
	
	
	private void kartaBirusa(Jokalaria jokalari1,Jokalaria jokalari2,Jokalaria  jokalari3,Jokalaria jokalari4) {
		Tableroa tableroa=Tableroa.getNiretableroa();
		this.teklatuaKanpo(jokalari1, jokalari2, jokalari3, jokalari4);
		if(ListaJokalariak.getNireListaJokalariak().lortuJokalariaPos(this.bigarrenAukera).koloreBerdinekoOrganoaDago((Birusa)jokalari1.lortuKartaPosizioarekin(this.lehenAukera))){
			if(ListaJokalariak.getNireListaJokalariak().lortuJokalariaPos(this.bigarrenAukera).koloreBerdinekoOrganoaLortu((Birusa)jokalari1.lortuKartaPosizioarekin(this.lehenAukera)).erdiBakunatuta()) {
				ListaJokalariak.getNireListaJokalariak().lortuJokalariaPos(this.bigarrenAukera).koloreBerdinekoOrganoaLortu((Birusa)jokalari1.lortuKartaPosizioarekin(this.lehenAukera)).bakunaKendu();
			}
			else {
				ListaJokalariak.getNireListaJokalariak().lortuJokalariaPos(this.bigarrenAukera).koloreBerdinekoOrganoaLortu((Birusa)jokalari1.lortuKartaPosizioarekin(this.lehenAukera)).birusKopHanditu();
			}
			if(ListaJokalariak.getNireListaJokalariak().lortuJokalariaPos(this.bigarrenAukera).koloreBerdinekoOrganoaLortu((Birusa)jokalari1.lortuKartaPosizioarekin(this.lehenAukera)).guztizBakunatuta()) {		
				System.out.println("Organoa guztiz bakunatuta dago");
			}
			
			else if(ListaJokalariak.getNireListaJokalariak().lortuJokalariaPos(this.bigarrenAukera).koloreBerdinekoOrganoaLortu((Birusa)jokalari1.lortuKartaPosizioarekin(this.lehenAukera)).guztizInfektatuta()) {
				tableroa.deskartatu(ListaJokalariak.getNireListaJokalariak().lortuJokalariaPos(this.bigarrenAukera).koloreBerdinekoOrganoaLortu((Birusa)jokalari1.lortuKartaPosizioarekin(this.lehenAukera)));
				ListaJokalariak.getNireListaJokalariak().lortuJokalariaPos(this.bigarrenAukera).organoaKendu(jokalari2.koloreBerdinekoOrganoaLortu((Birusa)jokalari1.lortuKartaPosizioarekin(this.lehenAukera)));
				jokalari1.birusaKendu(this.lehenAukera);
				System.out.println("Organoa"+ListaJokalariak.getNireListaJokalariak().lortuJokalariaPos(this.bigarrenAukera).getIzena()+"-ren mahaitik deskarteetara pasatu egin da");
			}
		}
		else {
			System.out.println("Ez dago kolore berdineko organorik");
		}
	}
	
	private void kartaBotika(Jokalaria jokalari1,Jokalaria jokalari2,Jokalaria jokalari3,Jokalaria jokalari4) {
		Tableroa tableroa=Tableroa.getNiretableroa();
		if(jokalari1.koloreBerdinekoOrganoaDago((Botika)jokalari1.lortuKartaPosizioarekin(this.lehenAukera)) && !jokalari1.koloreBerdinekoOrganoaLortu((Botika)jokalari1.lortuKartaPosizioarekin(this.lehenAukera)).guztizBakunatuta()) {
			if(jokalari1.koloreBerdinekoOrganoaLortu((Botika)jokalari1.lortuKartaPosizioarekin(this.lehenAukera)).erdiInfektatuta()) {
				jokalari1.koloreBerdinekoOrganoaLortu((Botika)jokalari1.lortuKartaPosizioarekin(this.lehenAukera)).birusaKendu();
			}
			else {
				jokalari1.koloreBerdinekoOrganoaLortu((Botika)jokalari1.lortuKartaPosizioarekin(this.lehenAukera)).bakunaKopHanditu();
			}
			tableroa.deskartatu((Botika)jokalari1.lortuKartaPosizioarekin(this.lehenAukera));
			jokalari1.botikaKendu(this.lehenAukera);
			if(jokalari1.organoGuztiakOsasuntsu()) {
				this.jokoaAmaitu=true;
				System.out.println("Zorionak "+jokalari1.getIzena()+" irabazi egin duzu");
			}
		}
		else {
			
			if(!jokalari1.koloreBerdinekoOrganoaDago((Botika)jokalari1.lortuKartaPosizioarekin(this.lehenAukera))) {
				System.out.println("Ez dago kolore berdineko organorik");
				this.botika=false;
			}
			else if(jokalari1.koloreBerdinekoOrganoaLortu((Botika)jokalari1.lortuKartaPosizioarekin(this.lehenAukera)).guztizBakunatuta()) {
				System.out.println("Organoa jada guztiz bakunatuta dago");
				this.botika=false;
			}
		}
	}
	
	private void kartaOrganoak(Jokalaria jokalari1,Jokalaria jokalari2,Jokalaria jokalari3,Jokalaria jokalari4) {
		if(!jokalari1.organoaJadaMahaian((Organoak)jokalari1.lortuKartaPosizioarekin(this.lehenAukera))) {
				jokalari1.mahaiaAktualizatu((Organoak)jokalari1.lortuKartaPosizioarekin(this.lehenAukera));
				jokalari1.organoaKendu((Organoak)jokalari1.lortuKartaPosizioarekin(this.lehenAukera));
				if(jokalari1.organoGuztiakOsasuntsu()) {
					this.jokoaAmaitu=true;
					System.out.println("Zorionak "+jokalari1.getIzena()+" irabazi egin duzu");
				}
			}
			
			else {
				System.out.println("Organoa jada zure mahailan dago");
				this.organoa=false;
			}
	}
	private void lehenengoOrganoak(Jokalaria jokalaria,Jokalaria jokalari2,Jokalaria jokalari3,Jokalaria jokalari4) {
		this.kartaOrganoak(jokalaria, jokalari2, jokalari3, jokalari4);
		if(this.organoa) {
			if(this.txanda==4) {
			this.txanda=1;
			}										
			else {
				this.txanda++;
			}
			this.txandaAmaitu=true;
		}
		else {
			this.teklatuaBarne(jokalaria);
			if(jokalaria.lortuKartaPosizioarekin(this.lehenAukera) instanceof Botika) {
				this.kartaBotika(jokalaria, jokalari2, jokalari3, jokalari4);
				if(this.botika) {
					if(this.txanda==4) {
						this.txanda=1;
					}										
					else {
						this.txanda++;
					}
					this.txandaAmaitu=true;
				}
				else {				
					this.teklatuaBarne(jokalaria);
					if(jokalaria.lortuKartaPosizioarekin(this.lehenAukera) instanceof Birusa) {
						this.kartaBirusa(jokalaria, jokalari2, jokalari3, jokalari4);
						if(this.birusa) {
							if(this.txanda==4) {
								this.txanda=1;
							}										
							else {
								this.txanda++;
							}
							this.txandaAmaitu=true;
						}
					}
				}
			}
		}
	}
	
	private void lehenegoBotika(Jokalaria jokalaria,Jokalaria jokalari2,Jokalaria jokalari3,Jokalaria jokalari4) {
		this.kartaBotika(jokalaria, jokalari2, jokalari3, jokalari4);
		if(this.botika) {
			if(this.txanda==4) {
			this.txanda=1;
			}										
			else {
				this.txanda++;
			}
			this.txandaAmaitu=true;
		}
		else {
			this.teklatuaBarne(jokalaria);
			if(jokalaria.lortuKartaPosizioarekin(this.lehenAukera) instanceof Organoak) {
				this.kartaOrganoak(jokalaria, jokalari2, jokalari3, jokalari4);
				if(this.organoa) {
					if(this.txanda==4) {
						this.txanda=1;
					}										
					else {
						this.txanda++;
					}
					this.txandaAmaitu=true;
				}
				else {				
					this.teklatuaBarne(jokalaria);
					if(jokalaria.lortuKartaPosizioarekin(this.lehenAukera) instanceof Birusa) {
						this.kartaBirusa(jokalaria, jokalari2, jokalari3, jokalari4);
						if(this.birusa) {
							if(this.txanda==4) {
								this.txanda=1;
							}										
							else {
								this.txanda++;
							}
							this.txandaAmaitu=true;
						}
					}
				}
			}
		}
	}
	
	private void lehenengoBirusa(Jokalaria jokalaria,Jokalaria jokalari2,Jokalaria jokalari3,Jokalaria jokalari4) {
		this.kartaBirusa(jokalaria, jokalari2, jokalari3, jokalari4);
		if(this.birusa) {
			if(this.txanda==4) {
			this.txanda=1;
			}										
			else {
				this.txanda++;
			}
			this.txandaAmaitu=true;
		}
		else {
			this.teklatuaBarne(jokalaria);
			if(jokalaria.lortuKartaPosizioarekin(this.lehenAukera) instanceof Organoak) {
				this.kartaOrganoak(jokalaria, jokalari2, jokalari3, jokalari4);
				if(this.organoa) {
					if(this.txanda==4) {
						this.txanda=1;
					}										
					else {
						this.txanda++;
					}
					this.txandaAmaitu=true;
				}
				else {				
					this.teklatuaBarne(jokalaria);
					if(jokalaria.lortuKartaPosizioarekin(this.lehenAukera) instanceof Botika) {
						this.kartaBotika(jokalaria, jokalari2, jokalari3, jokalari4);
						if(this.botika) {
							if(this.txanda==4) {
								this.txanda=1;
							}										
							else {
								this.txanda++;
							}
							this.txandaAmaitu=true;
						}
					}
				}
			}
		}
	}
	
	private void deskartatu() {
		
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
		
		while(!this.jokoaAmaitu) {
			this.txandaAmaitu=false;
			Jokalaria jokalaria=ListaJokalariak.getNireListaJokalariak().lortuJokalariaPos(this.txanda);
			if(this.txanda==2) {
				jokalari2=jokalari1;
			}
			else if(txanda==3) {
				jokalari3=jokalari1;
			}
			else if(txanda==4) {
				jokalari4=jokalari1;
			}
			while(!this.txandaAmaitu) {
				this.teklatuaBarne(jokalaria);
				if((jokalaria.lortuKartaPosizioarekin(this.lehenAukera) instanceof Organoak)){
					this.lehenengoOrganoak(jokalaria, jokalari2, jokalari3, jokalari4);
					this.botika=true;
					this.birusa=true;
					this.organoa=true;
				}
				else if(jokalaria.lortuKartaPosizioarekin(this.lehenAukera) instanceof Botika) {
					this.lehenegoBotika(jokalaria, jokalari2, jokalari3, jokalari4);
					this.botika=true;
					this.birusa=true;
					this.organoa=true;
				}
				else if(jokalaria.lortuKartaPosizioarekin(this.lehenAukera) instanceof Birusa) {
					this.lehenengoBirusa(jokalaria, jokalari2, jokalari3, jokalari4);
					this.botika=true;
					this.birusa=true;
					this.organoa=true;
				}
				else {
					
				}
			}
		}
	}
	
	public static void jokoaJolastu(String[] args) {
		Jokoa.getNireJokoa().jokoaHasieratu();
	}
}