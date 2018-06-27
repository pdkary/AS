package helpers;

import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class CastNow {
    public static void cast(String filename) throws IOException {
        try {
            Runtime.getRuntime().exec("castnow "+filename);
        } catch (IOException e) {
            System.out.println("An Error Occurred on CastNow");
        }
    }
}
