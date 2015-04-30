import java.nio.file.Path;
import java.nio.file.Paths;


public class ReduceFilePath {
	
	static Path reduceFilePath(Path path){
		return path.normalize();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path path = Paths.get("C:/Lokesh/Setup//workspace/../NIOExamples/src");
		System.out.println(reduceFilePath(path));
	}

}
