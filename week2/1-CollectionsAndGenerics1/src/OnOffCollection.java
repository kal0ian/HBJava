import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class OnOffCollection implements Collection{
	private List list = new ArrayList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		if(list.contains(e)){
			while(list.contains(e)){
				list.remove(e);
			}
			return false;
			
		}
		list.add(e);	
		return false;
		
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		boolean contain=false;
		for(int i=0;i<list.size();i++){
			if(list.get(i).equals(o)){
				contain=true;
			}
		}
		return contain;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

}
