import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Picerija {
	
	public static Krasns pica=null;
	
	static void PicasIzveide() {
		
		String Vards="Labaka";
		String Adrese="Abc123";
		String Tel="+371 123456789";
		int Izmers=5;
		String Merce="Tomatu";
		ArrayList<String> Piedevas = new ArrayList<String>();
		
		Piedevas.add("Sampinjoni");
		
		 pica = new Krasns("Viktors", "Liepaja", "345677", 15, "Motor ella", Piedevas, 12.49, true, 7.50);
		
	}
	
	static void Apskatit() {
		
        
        JOptionPane.showMessageDialog(null, pica.PicasInfo());
		
	}

	public static void main(String[] args) {
		
		 JFrame frame = new JFrame("Pizza pasta");
		 frame.setSize(640, 540);
	     frame.setLocationRelativeTo(null);
	     
		 JPanel panel = new JPanel();
		 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	     
	     
	     Image icon = Toolkit.getDefaultToolkit().getImage("Bilderes/Pica_logo.png").getScaledInstance(128,100, 100);   
	        frame.setIconImage(icon);

	        
	        JButton Pieteikties = new JButton("Pieteikties");
	        Pieteikties.addActionListener(e -> {
	        	Pieteiksanas.Audio();
	        }
	        );
	        
	        
	        JButton Pierakstities = new JButton("Pierakstīties");
	        
	        Pierakstities.addActionListener(e -> {
	        	 
	        }
	        );
	        
	        Dimension size = new Dimension(180, 45);

	        Pieteikties.setPreferredSize(size);
	        Pierakstities.setPreferredSize(size);
	        
	        Pieteikties.setAlignmentX(Component.CENTER_ALIGNMENT);
	        Pierakstities.setAlignmentX(Component.CENTER_ALIGNMENT);

	        panel.add(Box.createVerticalGlue());
	        panel.add(Pieteikties);
	        panel.add(Box.createVerticalStrut(100));
	        panel.add(Pierakstities);
	        panel.add(Box.createVerticalGlue());
	   /*  
	     JTextField Field = new JTextField(15);
	     JTextField countryCode = new JTextField(2);
	        countryCode.setText("+91");
	        countryCode.setEnabled(false);
	        panel.add(countryCode);
	        panel.add(Field);
	        */
	        frame.setContentPane(panel);

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        frame.setVisible(true);

	}

}
