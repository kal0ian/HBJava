import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TextFileCompression {

	public static String compress(Path filePath) throws FileNotFoundException{
		List<String> list = new ArrayList<String>();
		File file =filePath.toFile();
		String newContent="";
		Scanner scan = new Scanner(file);
		while(scan.hasNext()){
			String word = scan.next();
			int wordLen = word.length();
			if(word.charAt(wordLen-1)=='.' && list.indexOf(word.substring(0,wordLen-1))==-1){
				list.add(word.substring(0,wordLen-1));
				newContent+=" ~"+(list.size()-1)+".";
			}else if(word.charAt(wordLen-1)=='.' && list.indexOf(word.substring(0,wordLen-1))!= -1){
				newContent+=" ~"+list.indexOf(word.substring(0,wordLen-1))+".";
			
			}else{
				if(list.indexOf(word)==-1){
					list.add(word);
					newContent+=" ~"+(list.size()-1);
				}else{
					newContent+=" ~"+(list.indexOf(word));
				}
			}
		}
		scan.close();
		File outputFile = new File(file.getName()+".compr");
		PrintStream read = new PrintStream(file);
		read.println(newContent);
		read.close();
		PrintStream readCmp = new PrintStream(outputFile);
		readCmp.println(list.toString());
		return newContent;
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Path path = Paths.get("read.txt");
		System.out.println(compress(path));
	}

}
