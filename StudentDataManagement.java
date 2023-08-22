package codesoftTask4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Student {
	private String name;
	private int rollNumber;
	private String grade;

	public Student(String name, int rollNumber, String grade) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}

class StudentDataMangementSystem {
	private List<Student> students;

	public StudentDataMangementSystem() {
		students = new ArrayList<>();
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public void removeStudent(int rollNumber) {
		students.removeIf(student -> student.getRollNumber() == rollNumber);
	}

	public Student searchStudent(int rollNumber) {
		for (Student student : students) {
			if (student.getRollNumber() == rollNumber) {
				return student;
			}
		}
		return null;
	}

	public List<Student> getAllStudents() {
		return students;
	}
}

class DataStorage {
	private static final String FILENAME = "students.txt";

	public void writeStudentsToFile(List<Student> students) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
			for (Student student : students) {
				writer.println(student.getName() + "," + student.getRollNumber() + "," + student.getGrade());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Student> readStudentsFromFile() {
		List<Student> students = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 3) {
					Student student = new Student(parts[0], Integer.parseInt(parts[1]), parts[2]);
					students.add(student);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return students;
	}
}

public class StudentDataMangement {
	private StudentDataMangementSystem managementSystem;
	private DataStorage dataStorage;
	private Scanner scanner;

	public StudentDataMangement() {
		managementSystem = new StudentDataMangementSystem();
		dataStorage = new DataStorage();
		scanner = new Scanner(System.in);
	}

	public void run() {
		boolean running = true;

		while (running) {
			System.out.println("!!.......................................................................!!");
			System.out.println("!!                                                                       !!");
			System.out.println("!!....    Codesoft Task 5 - Student Management System                ....!!");
			System.out.println("!!                                                                       !!");
			System.out.println("!!.......................................................................!!");
			System.out.println("");
			System.out.println("Student Management System");
			System.out.println("1. Add Student");
			System.out.println("2. Remove Student");
			System.out.println("3. Search Student");
			System.out.println("4. Display All Students");
			System.out.println("5. Edit Student");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			int choice = getIntInput(1, 6);
			scanner.nextLine();

			switch (choice) {
			case 1:
				addStudent();
				break;
			case 2:
				removeStudent();
				break;
			case 3:
				searchStudent();
				break;
			case 4:
				displayAllStudents();
				break;
			case 5:
				editStudent();
				break;
			case 6:
				running = false;
				break;
			}
		}

		dataStorage.writeStudentsToFile(managementSystem.getAllStudents());
		scanner.close();
	}

	private void addStudent() {
		System.out.println("");
		System.out.println("TO ADD STUDENT PLEASE PROVIDE FURTHER INFORMATION");

		System.out.print("Enter student name: ");
		String name = scanner.nextLine().trim();

		System.out.print("Enter roll number: ");
		int rollNumber = getIntInput(1, Integer.MAX_VALUE);
		scanner.nextLine();

		System.out.print("Enter grade: ");
		String grade = scanner.nextLine();

		if (name.isEmpty() || grade.isEmpty()) {
			System.out.println("Name and grade cannot be empty.");
		} else {
			Student existingStudent = managementSystem.searchStudent(rollNumber);
			if (existingStudent != null) {
				System.out.println("Student with this roll number already exists.");
			} else {
				Student student = new Student(name, rollNumber, grade);
				managementSystem.addStudent(student);
				System.out.println("Student added successfully.");
			}
		}
	}

	private void removeStudent() {
		System.out.print("Enter roll number of student to remove: ");
		int rollNumber = getIntInput(1, Integer.MAX_VALUE);
		Student student = managementSystem.searchStudent(rollNumber);

		if (student != null) {
			managementSystem.removeStudent(rollNumber);
			System.out.println("Student removed successfully.");
		} else {
			System.out.println("Student not found.");
		}
	}

	private void searchStudent() {
		System.out.print("Enter roll number of student to search: ");
		int rollNumber = getIntInput(1, Integer.MAX_VALUE);
		Student student = managementSystem.searchStudent(rollNumber);

		if (student != null) {
			System.out.println("Student Found:");
			System.out.println("Name: " + student.getName());
			System.out.println("Roll Number: " + student.getRollNumber());
			System.out.println("Grade: " + student.getGrade());
		} else {
			System.out.println("Student not found.");
		}
	}

	private void editStudent() {
		System.out.print("Enter roll number of student to edit: ");
		int rollNumber = getIntInput(1, Integer.MAX_VALUE);
		Student student = managementSystem.searchStudent(rollNumber);

		if (student != null) {
			System.out.println("Editing Student:");
			System.out.println("1. Edit Name");
			System.out.println("2. Edit Roll Number");
			System.out.println("3. Edit Grade");
			System.out.println("4. Cancel");
			System.out.print("Enter your choice: ");
			int editChoice = getIntInput(1, 4);
			scanner.nextLine(); // Consume newline

			switch (editChoice) {
			case 1:
				System.out.print("Enter new name: ");
				String newName = scanner.nextLine().trim();
				student.setName(newName);
				System.out.println("Name updated.");
				break;
			case 2:
				System.out.print("Enter new roll number: ");
				int newRollNumber = getIntInput(1, Integer.MAX_VALUE);
				Student existingStudent = managementSystem.searchStudent(newRollNumber);
				if (existingStudent != null) {
					System.out.println("Student with this roll number already exists.");
				} else {
					student.setRollNumber(newRollNumber);
					System.out.println("Roll number updated.");
				}
				break;
			case 3:
				System.out.print("Enter new grade: ");
				String newGrade = scanner.nextLine();
				student.setGrade(newGrade);
				System.out.println("Grade updated.");
				break;
			case 4:
				System.out.println("Editing cancelled.");
				break;
			default:
				System.out.println("Invalid choice.");
			}
		} else {
			System.out.println("Student not found.");
		}
	}

	private void displayAllStudents() {
		List<Student> students = managementSystem.getAllStudents();
		if (students.isEmpty()) {
			System.out.println("No students found.");
		} else {
			System.out.println("Student List:");
			for (Student student : students) {
				System.out.println("Name: " + student.getName());
				System.out.println("Roll Number: " + student.getRollNumber());
				System.out.println("Grade: " + student.getGrade());
				System.out.println();
			}
		}
	}

	private int getIntInput(int min, int max) {
		int value;
		while (true) {
			try {
				value = scanner.nextInt();
				if (value < min || value > max) {
					System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
				} else {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.next();
			}
		}
		return value;
	}

	public static void main(String[] args) {
		StudentDataMangement consoleUI = new StudentDataMangement();
		consoleUI.run();
	}
}
