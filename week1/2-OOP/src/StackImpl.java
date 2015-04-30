
public class StackImpl implements Stack {

	private Element top;
	
	public void push(int x){
		if(checkElem(x)){
			System.out.println("There is elem "+x);
			return;
		}
		Element elem=new Element();
		elem.key=x;
		elem.next=top;
		top=elem;
	}
	public void pop(){
		if(empty()){
			System.out.println("Stack is empty");
		}
		else{
			top=top.next;	
		}
	}
	public boolean checkElem(int x){
		StackImpl s= new StackImpl();
		int buf;
		boolean flag=false;
		while(!empty()){
			buf=top();
			if(buf==x)flag=true;
			s.push(buf);
			pop();
		}
		while(!s.empty()){
			buf=s.top();
			push(buf);
			s.pop();
		}
		return flag;
	}
	public int top(){
		return top.key;
	}
	public boolean empty(){
		return top==null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackImpl s=new StackImpl();
		s.push(2);
		s.push(3);
		s.push(3);
		while(!s.empty()){
			System.out.println(s.top());
			s.pop();
		}
	}

}

class Element{
	int key;
	Element next;
}
