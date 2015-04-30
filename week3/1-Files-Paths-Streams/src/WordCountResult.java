import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;


public class WordCountResult {

	File file;
	WordCountResult(Path path){
		this.file=path.toFile();
	}
	WordCountResult(File file){
		this.file=file;
	}
	
	int getLineCount() throws IOException{
		Scanner scan = new Scanner(file);
		int lines=0;
		while(scan.hasNextLine()){
			lines++;
			scan.nextLine();
		}
		scan.close();
		return lines;
	}
	int getWordCount() throws FileNotFoundException{
		String content = FileUtils.readFrom(file);
		String[] splited = content.split(" ");
		return splited.length;
	}
	int getCharacterCount() throws FileNotFoundException{
		String content = FileUtils.readFrom(file);
		String[] splited = content.split("");
		return splited.length;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WordCountResult obj= new WordCountResult(new File("read.txt"));
		System.out.println(obj.getLineCount());
		System.out.println(obj.getCharacterCount());
		System.out.println(obj.getWordCount());
		
	}

}
