import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class OccurencesOfWords {

	public static Map<String,Integer> countOcurrences(String str){
		String[] words = str.split(" ");
		Map<String,Integer> occurences = new LinkedHashMap<String, Integer>();
		for(int i=0;i<words.length;i++){
			if(occurences.containsKey(words[i])){
				occurences.put(words[i], occurences.get(words[i]) + 1);
			}else{
				occurences.put(words[i],1);
			}
			
		}
		return occurences;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countOcurrences("Ninjas are all over the place! We are all going to die!"));
	}

}
