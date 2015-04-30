import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SortStudents implements Comparable<SortStudents>{

	int grade;
	String name;
	public SortStudents(int g,String n){
		grade=g;
		name=n;
	}
	@Override
	public String toString() {
		return "SortStudents " + grade + ", " + name + "]";
	}
	
	@Override
	public int compareTo(SortStudents student) {
		// TODO Auto-generated method stub
		return this.grade - student.grade;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortStudents student1 = new SortStudents(4,"pesho");
		SortStudents student2= new SortStudents(1,"pesho2");
		SortStudents student3= new SortStudents(5,"pesho2");
		List<SortStudents> students= new ArrayList<SortStudents>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		Collections.sort(students);
		System.out.println(students);
	}
}
