// Define class Student(Roll no, name, marks) & preform
// 1. Accept student details
// 2. Display student scoring maximum marks

import java.util.Scanner;

class Student{ 
	int rollNo, marks;
	String name;

	Student(int rollNo, String name, int marks){
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
	}

}

public class Q3{
	public static void main(String[] args){
		
		Student[] students = acceptStudents();	// students object array

		int max= students[0].marks, studId = 0; 
		// student with maximum marks

		for(int i = 1; i < students.length; i++){
			if(students[i].marks > max){
				studId = i;
				max = students[i].marks;
			}
		}
		System.out.println("Student with maximum mark is "+ students[studId].name + " with marks " + students[studId].marks);
	}

	public static Student[] acceptStudents(){
		// function to accept students
		Scanner s = new Scanner(System.in);
		int totalStudents, rollNo, marks;
		String name, temp;

		System.out.println("How many records you want to add :");
		totalStudents = s.nextInt();

		Student students[] = new Student[totalStudents]; // creating students object array

		for(int i = 0; i < totalStudents; i++){
			System.out.print("\nEnter student roll no of student " + (i + 1) + " : ");
			rollNo = s.nextInt();
			System.out.print("\nEnter student name of student " +(i + 1) + " : ");
			temp = s.nextLine();
			name = s.nextLine();
			System.out.print("\nEnter student marks of student "+ (i + 1) + " : ");
			marks = s.nextInt();

			students[i] = new Student(rollNo,name, marks); // creating new student object & adding to students array
		}
		return students;
	}

}
