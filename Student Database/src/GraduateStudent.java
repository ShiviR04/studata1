import java.io.*;

public class GraduateStudent extends Student{
	String major;
	public GraduateStudent(String name, String studentID, String major) {
		super(name, studentID);
		this.major = major;
	}
	
	public void print4() {
		System.out.println("\nStudent name: " + name + "\nStudent Id: " + studentID + "\nMajor: " + major);
}

}
