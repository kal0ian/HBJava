
public class Pair {

	/**
	 * @param args
	 */
	private Object first;
	private Object second;
	
	
	public Object getFirst() {
		return first;
	}

	public void setFirst(Object first) {
		this.first = first;
	}

	public Object getSecond() {
		return second;
	}

	public void setSecond(Object second) {
		this.second = second;
	}

//	@Override
//	public boolean equals(Object obj){
//		Pair p = (Pair)obj; 
//		return p.getFirst().equals(first)  && p.getSecond().equals(second);
//		
//	}
	
	@Override
	public String toString(){
		return "Pair["+getFirst()+","+getSecond()+"]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}


}
