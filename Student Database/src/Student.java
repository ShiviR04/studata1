import java.io.*;

public class Student extends Person{
	String studentID;
	public Student(String name, String studentID) {
		super(name);
		this.studentID = studentID;
	}
	public void print2() {
		System.out.println("\nStudent Name: " + name + "\nStudent ID: " + studentID);
	}

}
