import java.util.*;

public class Database {
	public static void main(String[] args) throws InterruptedException {
		try {
			Scanner scanner = new Scanner(System.in);
			int programRun = 1;
			List<Person> people = new ArrayList<Person>();

			while (programRun == 1) {
				System.out.println("\nEnter 0 to stop program");
				System.out.println("Enter 1 to enter a person's information");
				System.out.println("Enter 2 to print all People, Students, Undergraduates, or GraduateStudents");
				System.out.println("Enter 3 to print all people with the same grade level");
				System.out.println("Enter 4 to print all people with the same major");
				System.out.println("\nIf there is a blank space after enter please press enter again! ");
				System.out.println("\n\nEnter what you would like to do: ");
				int userInput = scanner.nextInt();

				if (userInput == 0) {
					System.out.println("Thank you!");
					System.exit(0);
				}

				if (userInput == 1) {
					scanner.nextLine();

					System.out.println("Enter 1 for person: ");
					System.out.println("Enter 2 for Students: ");
					System.out.println("Enter 3 for Undergraduates: ");
					System.out.println("Enter 4 for GraduateStudents: ");
					int whatPrint = scanner.nextInt();

					System.out.println("How many people would you like to enter: ");
					int peopleNum = scanner.nextInt();
					int peopleRun = 0;
					for (int i = 0; i < peopleNum; i++) {
						scanner.nextLine();
						System.out.println("Enter student name: ");
						String name = scanner.nextLine();
						name = name.trim();
						if (whatPrint == 1) {
							people.add(new Person(name));
							continue;
						}

						System.out.println("Enter studentID: ");
						String studentID = scanner.nextLine();
						if (whatPrint == 2) {
							people.add(new Student(name, studentID));
							continue;
						}

						System.out.println("Enter grade (freshman, sophmore, junior, & senior): ");
						String grade = scanner.nextLine();
						grade = grade.trim();
						while (!(grade.equals("freshman") || grade.equals("sophmore") || grade.equals("junior")
								|| grade.equals("senior"))) {
							System.out.println("Try again!");
							grade = scanner.nextLine();
						}
						if (whatPrint == 3) {
							people.add(new Undergraduate(name, studentID, grade));
							continue;
						}

						System.out.println("Enter major: ");
						String major = scanner.nextLine();
						people.add(new GraduateStudent(name, studentID, major));

						if (whatPrint == 4) {
							people.add(new GraduateStudent(name, studentID, major));
							continue;
						}

					}
				}

				if (userInput == 2) {
					System.out.println("Enter 1 to print persons: ");
					System.out.println("Enter 2 to print Students: ");
					System.out.println("Enter 3 to print Undergraduates: ");
					System.out.println("Enter 4 to print GraduateStudents: ");
					int whatPrint = scanner.nextInt();
					if (people.size() != 0) {
						if (whatPrint == 1) {
							for (int i = 0; i < people.size(); i++) {
								if ((people.get(i) instanceof Person) && !people.get(i).name.equals(null)) {
									people.get(i).print1();
								}
							}
						}
						if (whatPrint == 2) {
							for (int i = 0; i < people.size(); i++) {
								if (people.get(i) instanceof Student) {
									((Student) people.get(i)).print2();
								}
							}
						}
						if (whatPrint == 3) {
							for (int i = 0; i < people.size(); i++) {
								if (people.get(i) instanceof Undergraduate) {
									((Undergraduate) people.get(i)).print3();
								}
							}
						}
						if (whatPrint == 4) {
							for (int i = 0; i < people.size(); i++) {
								if (people.get(i) instanceof GraduateStudent) {
									((GraduateStudent) people.get(i)).print4();
								}
							}
						}
					} else {
						System.out.println("You have no people in your program!");
					}
				}

				if (userInput == 3) {
					for (int i = 0; i < people.size(); i++) {
						if (people.get(i) instanceof Undergraduate) {
							if (i != 0) {
								String value1 = ((Undergraduate) people.get(i - 1)).compareGrade();
								for (int j = 0; j < people.size(); j++) {
									if (((Undergraduate) people.get(j)).compareGrade().equals(value1)) {
										((Undergraduate) people.get(j)).print3();
									}
								}
							}
						}

					}
				}

				if (userInput == 4) {
					for (int i = 0; i < people.size(); i++) {
						if (people.get(i) instanceof GraduateStudent) {
							if (i != 0) {
								String value1 = ((Undergraduate) people.get(i - 1)).compareGrade();
								for (int j = 0; j < people.size(); j++) {
									if (((Undergraduate) people.get(j)).compareGrade().equals(value1)) {
										((Undergraduate) people.get(j)).print3();
									}
								}
							}
						}

					}
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Please Enter a valid input! ");
			System.out.println("Program is exiting! ");
			System.exit(0);
		}
	}
}
