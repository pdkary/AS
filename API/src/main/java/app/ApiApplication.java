package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import config.FileConfig;
import helpers.CastNow;
import helpers.FileFinder;
import helpers.PyHelper;

@SpringBootApplication
@ComponentScan(basePackageClasses = { PyHelper.class, FileConfig.class, CastNow.class, FileFinder.class,AxeRestController.class })
public class ApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ApiApplication.class, args);

		AxeRestController axe = ctx.getBean(AxeRestController.class);
		System.out.println(axe.pyHelper.pyFile);
	}
}
