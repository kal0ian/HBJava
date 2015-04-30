
public class NoPermissionExept extends RuntimeException {
	public String getMessage(){
		String result="You have no permission!";
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
