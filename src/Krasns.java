import java.util.ArrayList;

public class Krasns {
	
	String klientaNsk, klientaAdrese, klientaLokacija;
	int izmers, klientaTel;
	double cena, piegadesCena;
	String merce;
	Boolean piegade;
	ArrayList<String> piedevas;
	ArrayList<String> dzerieni;
	ArrayList<String> uzkodas;
	
	public Krasns(String KlientaNsk, String KlientaAdrese, String KlientaLokacija, int KlientaTel, int Izmers, String Merce,
			ArrayList<String> Piedevas,ArrayList<String> Dzerieni, ArrayList<String> Uzkodas, double Cena, Boolean Piegade, double PiegadesCena){
		
		this.klientaNsk=KlientaNsk;
		this.klientaAdrese=KlientaAdrese;
		this.klientaLokacija=KlientaLokacija;
		this.klientaTel=KlientaTel;
		this.izmers=Izmers;
		this.merce=Merce;
		this.piedevas=Piedevas;
		this.dzerieni=Dzerieni;
		this.uzkodas=Uzkodas;
		this.cena=Cena;
		this.piegade=Piegade;
		this.piegadesCena=PiegadesCena;
	}
	
	public String PicasInfo(){
		return
	"\n Klienta informācija:"
	+"\n Vārds: "+klientaNsk
	+"\n Adrese: "+klientaAdrese
	+"\n Lokacija: "+klientaLokacija
	+"\n Telefons: (+371)"+klientaTel
	+"\n ----------------------------------------------"
	+"\n Picas informācija:"
	+"\n Picas diametrs: "+izmers
	+"\n Izvēlētā mērce: "+merce
	+"\n Piedevas: "+piedevas
	+"\n ----------------------------------------------"
	+"\n Papildus informācija:"
	+"\n Dzēriens: "+dzerieni
	+"\n Uzkodas: "+uzkodas
	+"\n ----------------------------------------------"
	+"\n Cenas informācija:"
	+"\n Picas cena: "+cena+" Eiro"
	+"\n Piegāde: "+piegade
	+"\n Papildus piemaksa par piegādi: "+piegadesCena
	+"\n -----------------------------------------------";	
	}

}
