import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Krasns {
	
	String klientaNsk, klientaAdrese, klientaTel;
	
	int izmers;
	double cena, piegadesCena;
	String merce;
	Boolean piegade;
	ArrayList<String> piedevas;
	ArrayList<String> dzerieni;
	ArrayList<String> uzkodas;
	
	public Krasns(String KlientaNsk, String KlientaAdrese, String KlientaTel, int Izmers, String Merce,
			ArrayList<String> Piedevas,ArrayList<String> Dzerieni, ArrayList<String> Uzkodas, double Cena, Boolean Piegade, double PiegadesCena){
		
		this.klientaNsk=KlientaNsk;
		this.klientaAdrese=KlientaAdrese;
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
	+"\n Telefons: "+klientaTel
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
	+"\n Piegāde(Jā/Nē): "+piegade
	+"\n Papildus piemaksa par piegādi: "+piegadesCena
	+"\n -----------------------------------------------";	
	}

	public static void PicasIzveide() {
		
	 Krasns pica = null;
		
		do {
			String Vards=JOptionPane.showInputDialog(null);
			String Adrese=JOptionPane.showInputDialog(null);
			String Tel=JOptionPane.showInputDialog(null);
			int Izmers=Integer.parseInt(JOptionPane.showInputDialog(null));
			String Merce=JOptionPane.showInputDialog(null);
			ArrayList<String> Piedevas = new ArrayList<String>();
			ArrayList<String> Dzeriens = new ArrayList<String>();
			ArrayList<String> Uzkodas = new ArrayList<String>();
			
			int PiedevuSk=Integer.parseInt(JOptionPane.showInputDialog(null));
			int DzerienuSk=Integer.parseInt(JOptionPane.showInputDialog(null));
			int UzkoduSk=Integer.parseInt(JOptionPane.showInputDialog(null));
			
			for(int i=0;i<PiedevuSk;i++) {
				String piedevas = JOptionPane.showInputDialog(null, "Piedevu ievade");
				Uzkodas.add(piedevas);
				}
			
			for(int i=0;i<DzerienuSk;i++) {
				String dzeriens = JOptionPane.showInputDialog(null, "Dzerienu ievade");
				Uzkodas.add(dzeriens);
				}
			
			for(int i=0;i<UzkoduSk;i++) {
			String uzkoda = JOptionPane.showInputDialog(null, "Uzkodu ievade");
			Uzkodas.add(uzkoda);
			}
			
			 pica = new Krasns(Vards, Adrese, Tel, Izmers, Merce, Piedevas, Dzeriens, Uzkodas, 12.49, true, 7.50);
			}while(true);
		
		
	}
	
}
