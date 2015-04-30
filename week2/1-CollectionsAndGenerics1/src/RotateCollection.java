import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class RotateCollection {
	static void rotate(Collection collection, int rotateStep ){
		
		Integer[] arr = (Integer[])(collection.toArray(new Integer[collection.size()]));
		if(rotateStep==0)return;
		if(rotateStep>0){
			Integer x = arr[arr.length -1];
			for(int i=arr.length-2;i>=0;i--){
				arr[i+1]=arr[i];
			}
			arr[0]=x;
		}else{
			Integer x = arr[0];
			for(int i=0;i<arr.length-1;i++){
				arr[i]=arr[i+1];
			}
			arr[arr.length-1]=x;
		}
		collection.clear();
		for(int i=0;i<arr.length;i++){
			collection.add(arr[i]);
		}
		if(rotateStep>0)rotate(collection,rotateStep-1);
		else{
			rotate(collection,rotateStep+1);
		}
	}
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		rotate(l,-2);
		System.out.println(l.toString());
	}
}
