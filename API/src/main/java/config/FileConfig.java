package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import helpers.CastNow;
import helpers.FileFinder;
import helpers.PyHelper;

@Configuration
public class FileConfig {
	
	public static String pyFile = "C:\\Users\\pdkar\\Documents\\Programming\\Python\\SparrowCL.py";
	public static String homeDirectory = "C:\\Users\\pdkar\\Videos\\Torrents";

	@Bean
	public PyHelper pyHelper() {
		return new PyHelper(FileConfig.pyFile, null);
	}

	@Bean
	public FileFinder fileFinder() {
		return new FileFinder(FileConfig.homeDirectory);
	}

	@Bean
	public CastNow castNow() {
		return new CastNow();
	}
}
