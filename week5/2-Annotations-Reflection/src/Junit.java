import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;


public class Junit {

	public static void parse(Class<?> c) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		Object newInstance = c.newInstance(); 
		Method[] methods = c.getMethods();
		for(Method m:methods){
			if(m.isAnnotationPresent(Execute.class)){
				System.out.print(m.invoke(newInstance,"sad"));
			}
			
		}
	}
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		// TODO Auto-generated method stub
		Junit j = new Junit();
		j.parse(Tests.class);
	}

}
