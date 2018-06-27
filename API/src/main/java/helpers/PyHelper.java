package helpers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PyHelper {
	
	@Autowired
	public String pyFile;

	public String request;

	public String getPyFile() {
		return pyFile;
	}

	public void setPyFile(String pyFile) {
		this.pyFile = pyFile;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public void Sparrow(String title) {
		String name = String.valueOf(title);
		System.out.println("Sparrow called with: " + name);
		try {
			Runtime.getRuntime().exec("python27 " + pyFile + " \"" + name + "\"");
			System.out.println("python27 " + pyFile + " \"" + name + "\"");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}