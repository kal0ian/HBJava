import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class DublicatingElements {

	public static <T> Set dublicatingElems(Set<T>... sets){
		Set<T> result = new HashSet();
		int i=-1;
		boolean flag;
		T[] set0 = (T[]) sets[0].toArray();
		while(i<set0.length-1){
			flag=true;
			i++;
			T curElem=set0[i];
			for(int j=1;j<sets.length;j++){
				if(!sets[j].contains(curElem)){
					flag=false;
					break;
				}	
			}
			if(flag==true)result.add(curElem);
		}
		return result;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> a=new HashSet<Integer>();
		a.add(1);a.add(2);a.add(4);a.add(3);a.add(5);
		Set<Integer> b=new HashSet<Integer>();
		b.add(4);b.add(5);b.add(6);
		Set<Integer> c=new HashSet<Integer>();
		c.add(6);c.add(7);c.add(5);c.add(8);
		System.out.println(dublicatingElems(a,b,c).toString());
	}

}
