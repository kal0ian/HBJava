// kompoziciq 
import java.util.Stack;


public class Brackets {

	public static boolean checkBrackets(String str){
		Stack<Character> s=new Stack<Character>();
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='('){
				s.push(str.charAt(i));
			}
			else if(str.charAt(i)==')'){
				if(s.empty())return false;
				s.pop();
			}
		}
		return s.isEmpty();
	}
	public static void main(String[] args){
		System.out.println(checkBrackets("(()()()())"));
	}
}
