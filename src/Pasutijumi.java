import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Pasutijumi {

	public static void SaglabatPasutijumu(String info) {
		try {
			
	        String userHome = System.getProperty("user.home");
	        File desktop = new File(userHome + File.separator + "Desktop" + File.separator + "VeiktiePasutijumi.txt");

	        try (FileWriter FW = new FileWriter(desktop, true)) {
	        	FW.write(info);
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ApskatitNeaktivos() {
	try {
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		
		 String userHome = System.getProperty("user.home");
	        File desktopFile = new File(userHome + File.separator + "Desktop" + File.separator + "VeiktiePasutijumi.txt");

	        if (!desktopFile.exists()) {
	            JOptionPane.showMessageDialog(null, "Nav atrasts no ka lasīt!");
	            return;
	        }

	        try (BufferedReader Lasitajs = new BufferedReader(new FileReader(desktopFile))) {
	        	StringBuilder info = new StringBuilder();
	            String linija;
	            while ((linija = Lasitajs.readLine()) != null) {
	            	 info.append(linija).append('\n');
	            }
	    		String beigas = info.toString();
	    		panel.add(new JLabel("<html>"+beigas.replace("\n", "<br>")));
	        }
		
		 JScrollPane scrollPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		JFrame frame = new JFrame("Pasutijumi");
		frame.add(scrollPane);
		frame.setSize(640, 540);
    frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
	}catch(IOException e) {
		System.out.println(e);
	}
		
	}
}
