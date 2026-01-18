import java.awt.Component;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
			BufferedReader Lasitajs = (new BufferedReader(new FileReader("Darbinieki/Saraksts")));
			
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

			StringBuilder info = new StringBuilder();
			String linija;

			while ((linija = Lasitajs.readLine()) != null) {
			    info.append(linija).append('\n');
			}

			String beigas = info.toString();
			
			panel.add(new JLabel("<html>"+beigas.replace("\n", "<br>")));
			
			 JScrollPane scrollPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

			JFrame frame = new JFrame("Pasutijumi");
			frame.add(scrollPane);
			frame.setSize(640, 540);
	    frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		
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
	     
	     Dimension size = new Dimension(90, 45);
	     User.setPreferredSize(size);
	     Password.setPreferredSize(size);
	     Apstiprinat.setPreferredSize(new Dimension(180, 45));
        
    	 User.setAlignmentX(Component.CENTER_ALIGNMENT);
    	 Password.setAlignmentX(Component.CENTER_ALIGNMENT);
    	 Apstiprinat.setAlignmentX(Component.CENTER_ALIGNMENT);

    	panel.add(Box.createVerticalStrut(100));
        panel.add(Box.createVerticalGlue());
        panel.add(User);
        panel.add(Box.createVerticalStrut(100));
        panel.add(Password);
        panel.add(Box.createVerticalStrut(100));
        panel.add(Password);
        panel.add(Box.createVerticalStrut(100));
        panel.add(Apstiprinat);
        panel.add(Box.createVerticalGlue());
		 
		 frame.setContentPane(panel);

	      frame.setVisible(true);
		
	}
	
}
