import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class FindBrokenLinks {
	
	static void brokenLinks(Path path) throws IOException{
		File pathToFile = path.toFile();
		File[] files = pathToFile.listFiles();
		List<File> directories = new ArrayList<File>();
		for(File file:files){
			if(file.isDirectory()){
				directories.add(file);
			}else{
				if(Files.isSymbolicLink(file.toPath())){
					if(!Files.readSymbolicLink(file.toPath()).toFile().exists()){
						System.out.println(file.toString());
					}
				}
			}
		}
		for (File directory : directories) {
	        brokenLinks(directory.toPath());
	    }
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path path = Paths.get("/home/kal0ian/Downloads/");
		brokenLinks(path);
	}

}
