
public class List implements ListInterface {

	
	private Node start;
	private Node end;
	
	public List(){
		start=null;
		end=null;
	}
	@Override
	public void add(int x) {
		// TODO Auto-generated method stub
		Node elem = end;
		end = new Node();
		end.key=x;
		end.next=null;
		if(elem!=null)elem.next=end;
		else start=end;
		end.prev=elem;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return start==null;
	}

	@Override
	public int remove() {
		// TODO Auto-generated method stub
		int x = 0;
		if(!empty()){
			x=end.key;
			if(start==end) start=end=null;
			else{
				end=end.prev;
				end.next=null;
			}
		}
		return x;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		int count=0;
		Node cur = start;
		while(cur!=null){
			count++;
			cur=cur.next;
		}
		return count;
	}

	@Override
	public int get(int elementIndex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHead() {
		// TODO Auto-generated method stub
		if(empty()){
			System.out.println("List is empty!");
			return 0;
		}
		return start.key;
	}

	@Override
	public int getTail() {
		// TODO Auto-generated method stub
		if(empty()){
			System.out.println("List is empty!");
			return 0;
		}
		return end.key;
	}
	
	public static void main(String[] args){
		List l=new List();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		int x=l.size();
		System.out.println(x);
	}
}

class Node{
	int key;
	Node next;
	Node prev;
}