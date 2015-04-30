import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.Scanner;


public class FileUtils {
	private FileUtils(){}
	
	static String readFrom(File file) throws FileNotFoundException {
		String fileContent = null;
		Scanner scan = new Scanner(file);
		while(scan.hasNextLine()){
			fileContent+= scan.nextLine()+'\n';
		}
		scan.close();
		return fileContent;
	}
	static String readFrom(Path path) throws FileNotFoundException{
		return readFrom(path.toFile());
	}
	
	static void writeTo(File file,String string) throws FileNotFoundException{
		PrintStream write = new PrintStream(file);
		write.println(string);
		write.close();
	}
	static void writeTo(Path path,String string) throws FileNotFoundException{
		writeTo(path.toFile(),string);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("read.txt");
		String str="Pesho";
		writeTo(file,str);
		System.out.println(readFrom(file));
	}
}
