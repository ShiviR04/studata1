import java.io.*;

public class Undergraduate extends Student {
	String grade;

	public Undergraduate(String name, String studentID, String grade) {
		super(name, studentID);
		this.grade = grade;
	}

	public void print3() {
		System.out.println("\nStudent name: " + name + "\nStudent Id: " + studentID + "\nGrade: " + grade);
	}

	public String compareGrade() {
		return grade;
	}

}
