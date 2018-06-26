package helpers;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PyHelper {
	
	@Resource(name="pyFile")
	public String pyFile;
	
    public String request;
    
    @Autowired
    public PyHelper(String pyFile) {
    	this.pyFile = pyFile;
    }
    
    public void Sparrow(String title){
    	String name = String.valueOf(title);
    	System.out.println("Sparrow called with: "+name);
    	try {
			Runtime.getRuntime().exec("python27 "+pyFile+" \""+name+"\"");
			System.out.println("python27 "+pyFile+" \""+name+"\"");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}