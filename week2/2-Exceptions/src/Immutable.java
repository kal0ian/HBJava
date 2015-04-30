import java.util.ArrayList;
import java.util.Collection;


public class Immutable<E> extends ArrayList<E> {

	
	Immutable(Collection<? extends E> collection){
		super.addAll(collection);
	}
	
	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		throw new NoPermissionExept();
	}
	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		throw new NoPermissionExept();
	}
	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		throw new NoPermissionExept();
	}
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		throw new NoPermissionExept();
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		throw new NoPermissionExept();
		
	}
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		throw new NoPermissionExept();
	}
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		throw new NoPermissionExept();
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		throw new NoPermissionExept();
	}
	@Override
	protected void removeRange(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		throw new NoPermissionExept();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
