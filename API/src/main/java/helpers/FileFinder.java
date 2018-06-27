package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import objects.Path;

@Component
public class FileFinder {
    public String homeDirectory;
	
	public ArrayList<Path> files;
    public String parent;
    public String keyword;
    public String[] keywords;
	
    @Autowired
	public FileFinder(String homeDirectory) {
    	this.homeDirectory = homeDirectory;
    	this.files = new ArrayList<Path>();
    }
	
    FilenameFilter filter = new FilenameFilter() {
        public boolean accept(File dir, String name) {
            for(String x:keyword.split("\\s")){
                if(name.contains(x))return true;
            }
            if((name.contains("season")||name.contains("Season")) && (dir.getName().contains(keywords[0]))){
                //System.out.println("found a season folder in " + dir.getParent());
                return true;
            }
            return false;
        }
    };

    public FileFinder search(String filePath,String keyword) {
        try {
            System.out.println("Trying to find [" + keyword + "] in [" + filePath + "]");
            this.keyword = keyword;
            this.keywords = keyword.split("\\s");
            this.parent = filePath;
            File path = new File(filePath);

            ArrayList<Path> paths = new ArrayList<Path>();
            File[] listOfFiles = path.listFiles(filter);

            for (File f : listOfFiles) {
                if (f.isDirectory()) search(f.getPath(), keyword);
                paths.add(new Path(f));
            }
            files.addAll(paths);
        } catch (NullPointerException e){}
        return this;
    }
    
    public Path specify() throws FileNotFoundException{
    	for(Path path: this.files) {
			boolean check = true;
			for (String y : this.keywords) {
				check = check && path.getName().contains(y);
			}
			if (check) {
				return path;
			}
		}
    	throw new FileNotFoundException("Cannot find file");
    }
}
