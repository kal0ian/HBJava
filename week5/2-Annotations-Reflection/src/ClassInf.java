import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.util.Arrays;


@ClassInfo(author="SAD",checked = true,  value = "", classes = {})
public class ClassInf extends Info2{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Info2 inf = new ClassInf();
		 Annotation[] anotArr = inf.getClass().getAnnotations();
		 
		 for(Annotation a:anotArr){
			 System.out.println(a.toString());	 
			 if(a instanceof ClassInfo){
				 System.out.println("Author: "+ ((ClassInfo) a).author());
				 System.out.println("Checked: "+ ((ClassInfo) a).checked());
				 System.out.println("Value: "+ ((ClassInfo) a).value());
			 }
		 }
	}
}
@ClassInfo(author="SAD123",checked = true,  value = "", classes = {})
class Info2{
	
}
