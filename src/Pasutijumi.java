import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Pasutijumi {

	public static void SaglabatPasutijumu(String info) {
		try {
			FileWriter FW = new FileWriter("Pasutijumi/Saglabatie", true);
			
			FW.write(info);
			
			
			FW.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ApskatitNeaktivos() {
	try {
		BufferedReader Lasitajs = (new BufferedReader(new FileReader("Pasutijumi/Saglabatie")));
		
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
}
