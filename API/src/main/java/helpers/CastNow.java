package helpers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CastNow {
	
	@Autowired
	public CastNow(){
		System.out.println("CastNow is open");
	}
	
    public void cast(String filename) throws IOException {
        try {
            Runtime.getRuntime().exec("castnow "+filename);
        } catch (IOException e) {
            System.out.println("An Error Occurred on CastNow");
        }
    }
}
