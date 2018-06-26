package objects;

import java.io.File;

public class Path {
	private String name;
	private String path;
	
	public Path(String name,String path) {
		this.name = name;
		this.setPath(path);
	}
	
	public Path(File file) {
		this.name = file.getName();
		this.setPath(file.getPath());
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
