import java.util.ArrayList;

public class Picerija {

	public static void main(String[] args) {
		
		Krasns pica = null;
		
		String Vards="Labaka";
		String Adrese="Abc123";
		String Tel="+371 123456789";
		
		int Izmers=5;
		String Merce="Tomatu";
		ArrayList<String> Piedevas = new ArrayList<String>();
		Piedevas.add("Nagi");
		Piedevas.add("Naglas");
		
		
		
		pica = new Krasns(Vards,Adrese,Tel,Izmers,Merce,Piedevas, 4.10, false, 0.00); 
		
		System.out.println(pica.PicasInfo());
		

	}

}
