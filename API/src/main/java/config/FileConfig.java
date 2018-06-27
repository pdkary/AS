package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileConfig {
	
	public static String pyFile = "C:\\Users\\pdkar\\Documents\\Programming\\Python\\SparrowCL.py";
	public static String homeDirectory = "C:\\Users\\pdkar\\Videos\\Torrents";
	
	@Bean
	public String pyFile() {
		return FileConfig.pyFile;
	}
	@Bean
	public String homeDirectory(){
		return FileConfig.homeDirectory;
	}
}
