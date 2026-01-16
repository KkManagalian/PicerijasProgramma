import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Pieteiksanas {

	public static void Audio(){
		
		try {
        	File Morning = new File("Audio/Good-Morning.wav");
        	File Startup = new File("Audio/Startup.wav");
        	
        	AudioInputStream audioStream;
			
        	audioStream = AudioSystem.getAudioInputStream(Startup);
			Clip clip1 = AudioSystem.getClip();					
            clip1.open(audioStream);
            clip1.start();
			
            Thread.sleep(1000);
            
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
	
}
