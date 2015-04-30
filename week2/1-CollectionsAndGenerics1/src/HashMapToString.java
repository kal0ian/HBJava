import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class HashMapToString {

	public static String mapToString(HashMap<? extends Object, ? extends Object> map){
		Iterator it = map.entrySet().iterator();
		String result="{";
		while(it.hasNext()){
			Map.Entry<Object, Object> entry = (Map.Entry<Object, Object>)it.next();
			System.out.println("key: "+entry.getKey()+" value: "+entry.getValue().toString());
			
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = new HashMap();
		map.put(1, 2);
		map.put(2, 2);
		mapToString((HashMap<? extends Object, ? extends Object>) map);
	}

}
