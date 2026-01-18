import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pieteiksanas {

	 // countryCode.setText("+91");
    //countryCode.setEnabled(false);
	
	public static void Success(){
		try {
        	File Morning = new File("Audio/Good-Morning.wav");
        	File Startup = new File("Audio/Startup.wav");
        	
        	AudioInputStream audioStream;
			
        	audioStream = AudioSystem.getAudioInputStream(Startup);
			Clip clip1 = AudioSystem.getClip();					
            clip1.open(audioStream);
            clip1.start();
            JOptionPane.showMessageDialog(null, "Sveicinam jūs ar šo fantastiskos dienu, cienijamais darbiniek.");
            Thread.sleep(1500);
            
            audioStream = AudioSystem.getAudioInputStream(Morning);
			Clip clip2 = AudioSystem.getClip();
            clip2.open(audioStream);
            clip2.start();
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public static void Meklet(String Mekletais, String Parole) {
		try {
			
			File Darbinieki = new File("/Saraksts");
			File Paroles = new File("/Paroles");
			BufferedReader Lasitajs = (new BufferedReader(new FileReader("Darbinieki")));
		
		String Darbinieks;

		
		do{
			Darbinieks = Lasitajs.readLine();
			System.out.println("Mekletais: "+Darbinieks);
			System.out.println("Ievaditais: "+Mekletais);
			if(Darbinieks.equals(Mekletais)) {
				Success();
				System.out.println("Good job");
			}else {
				System.out.println("Fuck you");
			}
		}while(Lasitajs.readLine()!=null);
		
		Lasitajs.close();
		
		}catch(IOException e) {
			System.out.println(e);
		}
	
	}
	
	public static void Pieteikties() {
		
		JFrame frame = new JFrame("Pizza pasta");
		 frame.setSize(640, 540);
	     frame.setLocationRelativeTo(null);
	     
		 JPanel panel = new JPanel();
		 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		 
	     JTextField User = new JTextField(20);
	     JTextField Password = new JTextField(20);
	     JButton Apstiprinat = new JButton("Pieteikties");
	     Apstiprinat.addActionListener(_ ->{
	    		 
	    	 String	Darbinieks=User.getText();
	    	 String	Parole=Password.getText();
	    		 Meklet(Darbinieks, Parole);
	    		 
	});
	     
	     	panel.add(User); 
	        panel.add(Password);
	        panel.add(Apstiprinat);
		 
		 frame.setContentPane(panel);

	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	      frame.setVisible(true);
		
	}
	
}
