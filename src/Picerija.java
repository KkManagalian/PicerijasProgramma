import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Picerija {
	
	public static Krasns pica = null;
	public static ArrayList<String> AktivPasutijumi = new ArrayList<String>();
 	
 	public static void Success(){
 		try {
 			
 		    Clip clip1 = AudioSystem.getClip();
 		    AudioInputStream ais1 = AudioSystem.getAudioInputStream( Picerija.class.getResource("/Audio/Startup.wav"));
 		    clip1.open(ais1);
 		    clip1.start();

 		    JOptionPane.showMessageDialog(null,"Sveicinam jūs ar šo fantastiskos dienu, cienījamais darbiniek.");

 		    Clip clip2 = AudioSystem.getClip();
 		    AudioInputStream ais2 = AudioSystem.getAudioInputStream(Picerija.class.getResource("/Audio/Good-Morning.wav"));
 		    clip2.open(ais2);
 		    clip2.start();

 		} catch (Exception e) {
 		    e.printStackTrace();
 		}
		
	}
	
	public static String VirknesParbaude(String zinojums, String noklusejums) {
		String virkne;
		do {
			virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			if(virkne == null)
				return null;
			virkne = virkne.trim();
		}while(!Pattern.matches("^[\\p{L}\\p{N} ]+$", virkne));
		return virkne;
	}
	
	public static int SkaitlaParbaude(String zinojums, int min, int max) {
		
		int skaitlis;
		while(true) {
			String ievade = JOptionPane.showInputDialog(null, zinojums, "Datu ievade", JOptionPane.INFORMATION_MESSAGE);
			if(ievade == null)
				return -1;
			try {
				skaitlis = Integer.parseInt(ievade);
				if(skaitlis<min || skaitlis>max) {
					JOptionPane.showMessageDialog(null, "Norādīts nederīgs intervāls", "Nekorekti dati", JOptionPane.WARNING_MESSAGE);
					continue;
				}
				return skaitlis;
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Netika ievadīts vesels skaitlis", "Nekorekti dati", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static void PasutijumuIzveide() {
		
			String Vards = VirknesParbaude("Ievadiet klienta vārdu", "Jānis");
			if(Vards==null) {
				return;
			}
			
			int Izvele = JOptionPane.showConfirmDialog(null, "Vai būs vajadzīga piegāde?","Piegādes izvēle",JOptionPane.YES_NO_CANCEL_OPTION);
			boolean Piegade=false;
			
			String Lokacija="Liepāja";
			double PiegadesCena=0.0;
			
			switch(Izvele) {
			case 0:
				Piegade=true;
				
				String[] Lokacijas= {"Liepāja", "Apkārt liepājai", "Ārpus liepājai"};
				Lokacija = (String)JOptionPane.showInputDialog(null,
						"Izvēlies klienta rādiusu no liepājas", "Lokāciju izvēle",
						JOptionPane.QUESTION_MESSAGE, null, Lokacijas, Lokacijas[0]);
				switch(Lokacija) {
				case"Liepāja":
					PiegadesCena=3.50;
					break;
				case"Apkārt liepājai":
					PiegadesCena=7.00;
					break;
				case"Ārpus liepājai":
					PiegadesCena=10.50;
					break;
				case null:
					return;
				default:
					return;
				}
				
				break;
				
			case 1:
				Piegade=false;
				break;
				
			case -1:
				return;
			}
			
			String Adrese = VirknesParbaude("Ievadiet klienta Adrese", "Lauku iela 50a");
			if(Adrese==null) {
				return;
			}
			
			int Telefons =SkaitlaParbaude("Ievadiet klienta telefonu", 999999, 9999999);
			if(Telefons==-1) {
				return;
			}
			
			Double Cena=0.0;
			
			String[] PicasIzmeri= {"15", "30", "45", "60"};
			String Izmeri = (String)JOptionPane.showInputDialog(null,
					"Izvēlies picas izmēru (cm)", "Izmēru izvēle",
					JOptionPane.QUESTION_MESSAGE, null, PicasIzmeri, PicasIzmeri[0]);
			int Izmers=0;
			if(Izmeri==null) {
				return;
			}else {
			Izmers=Integer.parseInt(Izmeri);
			switch(Izmers){
			case 15:
				Cena+=5.0;
				break;
			case 30:
				Cena+=7.5;
				break;
			case 45:
				Cena+=10.0;
				break;
			case 60:
				Cena+=12.5;
				break;
			}
			}
			
			String[] Merces= {"Tomātu mērce", "Barbeku mērce", "Majonēze", "Asā sarkanā mērce","Pesto"};
			String Merce = (String)JOptionPane.showInputDialog(null,
					"Izvēlies mērci picai", "Mērču izvēle",
					JOptionPane.QUESTION_MESSAGE, null, Merces, Merces[0]);
			if(Merce==null) {
				return;
			}
			Cena+=2.25;
			
			ArrayList<String> Piedevas = new ArrayList<String>();
			
			int PiedevuSk= SkaitlaParbaude("Ievadiet cik piedevas būs (0-10)",0 ,10);
			if(PiedevuSk==-1) {
				return;
			}
			String[] PiedevasIzv= {"Ananās", "Sēnes", "Paprika", "Sīpoli", "Olīves", "Tomāti"};
			
			for(int i=0;i<PiedevuSk;i++) {
			String Piedeva = (String)JOptionPane.showInputDialog(null,
					"Izvēlies picas piedevas", "Piedevu izvēle",
					JOptionPane.QUESTION_MESSAGE, null, PiedevasIzv, PiedevasIzv[0]);
			Cena+=0.75;
			if(Piedeva==null) {
				return;
			}
			Piedevas.add(Piedeva);
			}
			
			ArrayList<String> Dzeriens = new ArrayList<String>();

			int DzerienuSk= SkaitlaParbaude("Ievadiet cik dzērieni būs (0-6)",0 ,6);
			if(DzerienuSk==-1) {
				return;
			}
			String[] DzerienuIzv= {"Kafija", "Tēja", "Ābolu sula", "Apelsīnu sula", "Cola", "Sprites", "Fanta", "Marinētu gurķu sula (Ar gurķu gabaliņiem)"};
			
			for(int i=0;i<DzerienuSk;i++) {
			String Dzeramais = (String)JOptionPane.showInputDialog(null,
					"Izvēlies dzērienu", "Dzērienu izvēle",
					JOptionPane.QUESTION_MESSAGE, null, DzerienuIzv, DzerienuIzv[0]);
			Cena+=4.35;
			if(Dzeramais==null) {
				return;
			}
			Dzeriens.add(Dzeramais);
			}

			ArrayList<String> Uzkodas = new ArrayList<String>();
			
			int UzkoduSk= SkaitlaParbaude("Ievadiet cik uzkodas būs (0-6)",0 ,6);
			if(UzkoduSk==-1) {
				return;
			}
			String[] UzkoduIzv= {"Frī kartupeļi", "Tofu nūjiņas", "Ābolu šķēles"};
			
			for(int i=0;i<UzkoduSk;i++) {
			String Uzkoda = (String)JOptionPane.showInputDialog(null,
					"Izvēlies uzkodas", "Uzkodu izvēle",
					JOptionPane.QUESTION_MESSAGE, null, UzkoduIzv, UzkoduIzv[0]);
			switch(Uzkoda) {
			case"Frī kartupeļi":
				Cena+=2.15;
				break;
			case"Tofu nūjiņas":
				Cena+=3.00;
				break;
			case"Ābolu šķēles":
				Cena+=1.50;
				break;
			case null:
				return;
			default:
				return;
			}

			Uzkodas.add(Uzkoda);
			}
			
			pica = new Krasns(Vards, Adrese, Lokacija, Telefons, Izmers, Merce, Piedevas, Dzeriens, Uzkodas, Cena, Piegade, PiegadesCena);
			AktivPasutijumi.add(pica.PicasInfo());
	}
	
	public static void ApskatitAktivos() {
		if(AktivPasutijumi.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Pasūtījuma saraksts ir tukšs!", "Pasūtījuma status", JOptionPane.INFORMATION_MESSAGE);			
		}else {
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

   		 for (int i = 0; i < AktivPasutijumi.size(); i++) {
   		     panel.add(new JLabel("<html>"+(AktivPasutijumi.get(i).replace("\n", "<br>"))));
   		 }

   		 JScrollPane scrollPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
   			    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

   		JFrame frame = new JFrame("Pasutijumi");
   		frame.add(scrollPane);
   		frame.setSize(640, 540);
	    frame.setLocationRelativeTo(null);
   		frame.setVisible(true);
		}
		}
	
	public static void PabeigtPasutijumu() {
		if(AktivPasutijumi.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Pasūtījuma saraksts ir tukšs!", "Pasūtījuma status", JOptionPane.INFORMATION_MESSAGE);
		}else {
		AktivPasutijumi.removeFirst();
		Pasutijumi.SaglabatPasutijumu(pica.PicasInfo());
		JOptionPane.showMessageDialog(null, "Pasūtījums veiksmīgi pabeigts!", "Pasūtījuma status", JOptionPane.INFORMATION_MESSAGE);
	}
	}
	
	public static void main(String[] args) {
		
	JFrame frame = new JFrame("Picerija");
		 frame.setSize(640, 540);
	     frame.setLocationRelativeTo(null);
	    
	  	JPanel panel = new JPanel();
		 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	     
	     
	     Image icon = Toolkit.getDefaultToolkit().getImage("Bilderes/Pica_logo.png").getScaledInstance(128,100, 100);   
	        frame.setIconImage(icon);

	        
	        JButton Pieteikties = new JButton("Startēt programmu");
	        Pieteikties.addActionListener(_ -> {
	        	
	        	Success();
	        	
	        	panel.removeAll();
	        	
	       	 JButton IzveidotPasutijumu = new JButton("Izveidot jaunu pasūtijumu");
	       	 IzveidotPasutijumu.addActionListener(_ -> {
	       		 PasutijumuIzveide();
	       	 });
	       	 
	       	 JButton ApskatitAktivos = new JButton("Apskatīt aktīvos pasūtījumus");
	       	 ApskatitAktivos.addActionListener(_ -> {
	       		 ApskatitAktivos();
	       	 });
	       	 
	       	 JButton PabeigtPasutijumu = new JButton("Pabeigt pirmo pasūtījumu sarakstā");
	       	 PabeigtPasutijumu.addActionListener(_ -> {
	       		 PabeigtPasutijumu();
	       	 });
	       	 
	       	 JButton ApskatitNeaktivos = new JButton("Apskatīt neaktīvos pasūtījumus");
	       	 ApskatitNeaktivos.addActionListener(_ -> {
	       		 Pasutijumi.ApskatitNeaktivos();
	       	 });
	       	 
	       	 Dimension size = new Dimension(180, 45);
	       	 IzveidotPasutijumu.setPreferredSize(size);
	       	 ApskatitAktivos.setPreferredSize(size);
	       	 PabeigtPasutijumu.setPreferredSize(size);
	       	 ApskatitNeaktivos.setPreferredSize(size);
	           
	       	 IzveidotPasutijumu.setAlignmentX(Component.CENTER_ALIGNMENT);
	       	 ApskatitAktivos.setAlignmentX(Component.CENTER_ALIGNMENT);
	       	 PabeigtPasutijumu.setAlignmentX(Component.CENTER_ALIGNMENT);
	       	 ApskatitNeaktivos.setAlignmentX(Component.CENTER_ALIGNMENT);

	           panel.add(Box.createVerticalGlue());
	           panel.add(IzveidotPasutijumu);
	           panel.add(Box.createVerticalStrut(100));
	           panel.add(ApskatitAktivos);
	           panel.add(Box.createVerticalStrut(100));
	           panel.add(PabeigtPasutijumu);
	           panel.add(Box.createVerticalStrut(100));
	           panel.add(ApskatitNeaktivos);
	           panel.add(Box.createVerticalGlue());

	           panel.revalidate();
	           panel.repaint();
	       	
	        
	        });
	        
	        Dimension size = new Dimension(180, 45);

	        Pieteikties.setPreferredSize(size);
	        
	        Pieteikties.setAlignmentX(Component.CENTER_ALIGNMENT);

	        panel.add(Box.createVerticalGlue());
	        panel.add(Pieteikties);
	        panel.add(Box.createVerticalGlue());
	  
	        frame.setContentPane(panel);

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        frame.setVisible(true);

	}

}
