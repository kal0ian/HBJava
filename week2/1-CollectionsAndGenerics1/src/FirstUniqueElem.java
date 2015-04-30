import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class FirstUniqueElem {

	static <T> T unique (Collection<T> collection){
		T[] arr=(T[]) collection.toArray();
		TreeSet<T> set = new TreeSet();
		for(int i=0;i<arr.length;i++){
			if(set.contains(arr[i])){
				set.pollLast();
			}else{
				
				set.add(arr[i]);
			}
		}
		
		return set.iterator().next();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Collection<Integer> ints = Arrays.asList(1,2,5,7,1,3,4,4,3,7,5,1,2,10,15,8);
		System.out.println(unique(ints)) ;
	}

}
