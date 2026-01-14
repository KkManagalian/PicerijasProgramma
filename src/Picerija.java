import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Picerija {
	
	public static Krasns pica=null;
	
	static void Izsaukt() {
		
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
		
		String izvele;
		
		 JFrame frame = new JFrame("Pizza pasta");
		 frame.setSize(640, 540);
	        frame.setLocation(320, 240);
		 
		 JPanel panel = new JPanel();
	     panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	     
	     Image icon = Toolkit.getDefaultToolkit().getImage("Bilderes/Pica_logo.png").getScaledInstance(128,100, 100);
	        
	        frame.setIconImage(icon);

	        JLabel label = new JLabel("Nu kautka");
	        JButton egg = new JButton("Izveidot picu");
	        
	        egg.addActionListener(e -> {
	            egg.setEnabled(false);
	            Izsaukt();
	            JOptionPane.showMessageDialog(null, "Pica izveidota!");
	        }
	        );
	        
	        
	        JButton peg = new JButton("Apskatit picu");
	        
	        peg.addActionListener(e -> {
	        	 egg.setEnabled(true);
	        	 Apskatit();
	        }
	        );
	        
	        egg.setMaximumSize(new Dimension(100, 100));
	        
	        panel.add(egg);
	        panel.add(peg);
	        panel.add(label);
	        
	        frame.add(panel);

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        frame.setVisible(true);
		

	}

}
