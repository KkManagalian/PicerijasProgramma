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

	public static void main(String[] args) {
		
		 JFrame frame = new JFrame("Picerijas konta ieeja");
		 frame.setSize(640, 540);
	     frame.setLocationRelativeTo(null);
	     
		 JPanel panel = new JPanel();
		 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	     
	     
	     Image icon = Toolkit.getDefaultToolkit().getImage("Bilderes/Pica_logo.png").getScaledInstance(128,100, 100);   
	        frame.setIconImage(icon);

	        
	        JButton Pieteikties = new JButton("Pieteikties");
	        Pieteikties.addActionListener(e -> {
	        	Pieteiksanas.Success();
	        	
	        	panel.removeAll();
	        	
	        	 JButton IzveidotPasutijumu = new JButton("Izveidot jaunu pasūtijumu");
	        	 IzveidotPasutijumu.addActionListener(p -> {
	        		 Krasns.PicasIzveide();
	        	 });
	        	 JButton ApskatitAktivos = new JButton("Apskatīt aktīvos pasūtījumus");
	        	 ApskatitAktivos.addActionListener(p -> {
	        		 Pasutijumi.ApskatitAktivos();
	        	 });
	        	 JButton ApskatitNeaktivos = new JButton("Apskatīt neaktīvos pasūtījumus");
	        	 ApskatitNeaktivos.addActionListener(p -> {
	        		 Pasutijumi.ApskatitNeaktivos();
	        	 });
	        	 
	        	 Dimension size = new Dimension(180, 45);
	        	 IzveidotPasutijumu.setPreferredSize(size);
	        	 ApskatitAktivos.setPreferredSize(size);
	        	 ApskatitNeaktivos.setPreferredSize(size);
		        
	        	 IzveidotPasutijumu.setAlignmentX(Component.CENTER_ALIGNMENT);
	        	 ApskatitAktivos.setAlignmentX(Component.CENTER_ALIGNMENT);
	        	 ApskatitNeaktivos.setAlignmentX(Component.CENTER_ALIGNMENT);

		        panel.add(Box.createVerticalGlue());
		        panel.add(IzveidotPasutijumu);
		        panel.add(Box.createVerticalStrut(100));
		        panel.add(ApskatitAktivos);
		        panel.add(Box.createVerticalStrut(100));
		        panel.add(ApskatitNeaktivos);
		        panel.add(Box.createVerticalGlue());

	            panel.revalidate();
	            panel.repaint();
	        	
	        });
	        
	        
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
	  
	        frame.setContentPane(panel);

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        frame.setVisible(true);

	}

}
