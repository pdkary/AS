package app;

import java.io.IOException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import config.FileConfig;
import helpers.CastNow;
import helpers.FileFinder;
import helpers.PyHelper;
import objects.AxeRequestDto;
import objects.Path;

@RestController
public class AxeRestController {
	
    public PyHelper pyHelper;
	public CastNow castNow;
	public FileFinder fileFinder;
	public String latestCall;
	public String homeDirectory;
	
	@Autowired
	public AxeRestController(PyHelper pyHelper, CastNow castNow, FileFinder fileFinder) {
		this.pyHelper = pyHelper;
		this.castNow = castNow;
		this.fileFinder = fileFinder;
		this.homeDirectory = FileConfig.homeDirectory;
	}

	@RequestMapping(value="/Axe",method=RequestMethod.GET)
	public String Ace(){
		System.out.println(pyHelper.pyFile);
		return "on";
	}
	
	@RequestMapping(value="/Sparrow",method= RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public void Axe(@RequestBody AxeRequestDto payload){
		if(Optional.of(payload).isPresent()) {
			String result = payload.name;
			try {
				this.latestCall = result;
				pyHelper.Sparrow(result);
			}catch(Exception e) {
				System.out.println("Error: "+e+" occurred");
			}
		}
	}
    
    @RequestMapping(value="/File",method=RequestMethod.POST)
	public void castFile(@Valid @RequestBody AxeRequestDto payload) throws IOException {
		System.out.println("Recieved: "+payload.name);
		Path path = fileFinder.search(this.homeDirectory,payload.name).specify();
		System.out.println(homeDirectory+"\\"+path.getPath()+"\\"+path.getName());
		//castNow.cast(path.getPath());
	}
}