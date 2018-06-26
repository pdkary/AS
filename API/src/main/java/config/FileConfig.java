package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileConfig {
	
	@Bean(name="pyFile")
	public String pyFile() {
		return "C:\\Users\\pdkar\\Documents\\Programming\\Python\\SparrowCL.py";
	}
	@Bean(name="homeDirectory")
	public String homeDirectory() {
		return "C:\\Users\\pdkar\\Videos\\Torrents";
	}
}
