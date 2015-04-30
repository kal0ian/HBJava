import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class DublicatingFiles {

	static void dublicatingFiles(Path path,Map<Long,List<File>> dublicating){
		File file = path.toFile();
		List<File> directories = new ArrayList<File>();
		File[] files = file.listFiles();
		for(File f:files){
			if(f.isDirectory()){
				directories.add(f);
			}else{
				if(dublicating.containsKey(f.length())){
					List<File> list = dublicating.get(f.length());
					list.add(f);
					dublicating.put(f.length(),list);
					
				}else{
					List<File> list = new ArrayList<File>();
					list.add(f);
					dublicating.put(f.length(), list);
				}
			}
		}
		for(File directory:directories){
			dublicatingFiles(directory.toPath(),dublicating);
		}
	}
	
	static void hashMapToString(Map<Long,List<File>> map){
		int i=1;
		for( Map.Entry<Long, List<File>> v : map.entrySet() ) {
			System.out.println("Group"+i+": \n");
			listToString(v.getValue());
			i++;
		}
	}
	static void listToString(List<File> list){
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Long,List<File>> dublicating = new HashMap<Long,List<File> >();
		Path path = Paths.get("/home/kal0ian/Downloads/");
		dublicatingFiles(path,dublicating);
		hashMapToString(dublicating);
	}

}
