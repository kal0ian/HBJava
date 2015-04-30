
public class User {

	public String name;
	
	User(String n){
		name=n;
	}
	
	static void checkUser(User u) throws DatabaseCorruptedException{
		if(u.name.equals("")){
			throw new DatabaseCorruptedException();
		}
	}
	
	static void useService(User u) throws ServiceNotAvailableAtTheMoment{
		if(u.name.equals("")){
			throw new ServiceNotAvailableAtTheMoment();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u=new User("");

		try{
		useService(u);
		}catch(ServiceNotAvailableAtTheMoment s){
			System.out.println("Serveice Not Available!");
		}
	}

}
