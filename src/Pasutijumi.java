import java.io.FileWriter;
import java.io.IOException;

public class Pasutijumi {

	public static void SaglabatPasutijumu() {
		try {
			FileWriter FW = new FileWriter("Pasutijumi");
			
			
			
			FW.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void ApskatitAktivos() {
		
		
		
	}

	public static void ApskatitNeaktivos() {
	
	
	}
	
	
}
