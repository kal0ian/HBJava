import java.util.HashMap;


public class NotNullHashMapKey<K,V> extends HashMap<K,V>{
	
	boolean nullKey =false;
	
	
	public NotNullHashMapKey(boolean nullkey) {
		// TODO Auto-generated constructor stub
		this.nullKey = nullkey;
	}
	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		if(!nullKey && key==null){
			throw new NullPointerException();
		}
		return super.get(key);
	}
	
	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		if(!nullKey && key==null){
			throw new NullPointerException();
		}
		return super.put(key, value);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotNullHashMapKey<Integer,String> p = new NotNullHashMapKey<Integer, String>(true);
		p.put(1, null);
		p.nullKey=false;
		p.get(null);
	}

}
