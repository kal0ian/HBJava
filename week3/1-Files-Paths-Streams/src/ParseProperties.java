import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ParseProperties {
	
	static Map<String, String> parseProperties(File file) throws FileNotFoundException{
		Map<String, String> map = new HashMap();
		Scanner scan = new Scanner(file);
		while(scan.hasNextLine()){
			String line = scan.nextLine();
			if(line.indexOf('#')!=0){
				int index =line.indexOf('=');
				map.put(line.substring(0, index).trim(),line.substring(index+1).trim());
			}
		}
		return map;
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("file.properties");
		System.out.println(parseProperties(file));
	}

}
