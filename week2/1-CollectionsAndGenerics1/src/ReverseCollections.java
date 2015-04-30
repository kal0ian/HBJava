import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class ReverseCollections {
	
	static <T> void reverse (Collection<T> collection){
		T[] arr = (T[]) collection.toArray();
		
		for(int i = 0; i < arr.length/2; i++){
		    T temp = arr[i];
		    arr[i] = arr[arr.length - i - 1];
		    arr[arr.length - i - 1] = temp;
		}
		collection.clear();
		for(int i=0;i<arr.length;i++){
			collection.add(arr[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer>  a = new HashSet<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		reverse(a);
		System.out.println(a.toString());
		
		List<Integer> a1 = new ArrayList<Integer>();
		a1.add(1);
		a1.add(2);
		a1.add(3);
		reverse(a1);
		System.out.println(a1.toString());
	}

}
