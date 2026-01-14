import java.util.ArrayList;

public class Krasns {
	
	String klientaNsk, klientaAdrese, klientaTel;
	
	int izmers;
	double cena, piegadesCena;
	String merce;
	Boolean piegade;
	ArrayList<String> piedevas;
	
	
	public Krasns(String KlientaNsk, String KlientaAdrese, String KlientaTel, int Izmers, String Merce, ArrayList<String> Piedevas, double Cena, Boolean Piegade, double PiegadesCena){
		this.klientaNsk=KlientaNsk;
		this.klientaAdrese=KlientaAdrese;
		this.klientaTel=KlientaTel;
		this.izmers=Izmers;
		this.merce=Merce;
		this.piedevas=Piedevas;
		this.cena=Cena;
		this.piegade=Piegade;
		this.piegadesCena=PiegadesCena;
	}
	
	public String PicasInfo(){
		return
	"\n Klienta informācija:"
	+"\n Vārds: "+klientaNsk
	+"\n Adrese: "+klientaAdrese
	+"\n Telefons: "+klientaTel
	+"\n ----------------------------------------------"
	+"\n Picas informācija:"
	+"\n Picas diametrs: "+izmers
	+"\n Izvēlētā mērce: "+merce
	+"\n Piedevas: "+piedevas
	+"\n ----------------------------------------------"
	+"\n Cenas informācija:"
	+"\n Picas cena: "+cena+" Eiro"
	+"\n Piegāde(Jā/Nē): "+piegade
	+"\n Papildus piemaksa par piegādi: "+piegadesCena
	+"\n -----------------------------------------------";
		
		
	}
	
}
