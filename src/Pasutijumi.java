import java.io.FileWriter;
import java.io.IOException;

public class Pasutijumi {

	public static void SaglabatPasutijumu(String info) {
		try {
			FileWriter FW = new FileWriter("Pasutijumi", true);
			
			FW.write(info);
			
			
			FW.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ApskatitNeaktivos() {
	
	
		
	}
	
	
}
