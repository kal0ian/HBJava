import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.Scanner;


public class FixSubtitles {
	static void fixEncoding(Path path) throws IOException{
		File file = path.toFile();
		Scanner scan = new Scanner(file,"windows-1251");
		PrintStream stream = new PrintStream(file.getParent()+"/newSubs.txt","UTF-8");
		while(scan.hasNextLine()){
			String line = scan.nextLine();
			stream.println(line);
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("/home/kal0ian/Downloads/Shema_za_tochkuvane_&_ocenjavane.txt");
		fixEncoding(file.toPath());
		System.out.println(file.getName());
		
	}

}
