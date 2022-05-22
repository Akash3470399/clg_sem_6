import java.io.*;

class Person{
	String name, address;
}

class Student extends Person{
	
	String[] courses;
	String[] grades;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	Student() throws IOException {
		int temp;

		System.out.print("Enter Student name :");
		name = br.readLine();

		System.out.print("Enter  address :");
		address = br.readLine();
		
		System.out.print("No of courses in which you are enrolled :");
		temp = Integer.parseInt(br.readLine());

		courses = new String[temp];
		grades = new String[temp];

		for(int i = 0; i < temp; i++)
		{
			System.out.print("Course name :");
			courses[i] = br.readLine();
			
			System.out.print("Grade in "+ courses[i]+" :");
			grades[i] = br.readLine();
						
		}		
	}

	void displayDetails(){
		System.out.println("Name :"+ this.name);
		System.out.println("Address :" + this.address);
		
		System.out.println("Courses & respective grades in which "+ this.name + " enrolled.");	
		for(int i = 0; i < courses.length; i++)
			System.out.println("Course : " + courses[i] + "   Grade : " + grades[i]);
	}
}

class CourseNode{
	String name;
	CourseNode next;

	CourseNode(String name){
		this.name = name;
		this.next = null;
	}
}

class Teacher extends Person{
	CourseNode courses;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	Teacher() throws IOException{
		courses = null;
		System.out.print("Enter name :");
		this.name = br.readLine();

		System.out.print("Enter  address :");
		this.address = br.readLine();

	}
	void addCourse() throws IOException {
		String temp;
		int flag = 0;
		
		if(courses == null){
			System.out.print("Course name :");
			temp = br.readLine();
			courses = new CourseNode(temp);
		}
		else{
			CourseNode i;
			System.out.print("Course name :");
			temp = br.readLine();
			for(i = courses; i != null; i = i.next)
			{
				System.out.println(i.name);
				if(i.name.equals(temp)){
					System.out.println("Course already exists.");
					flag = 1;
					break;
				}
			}
			if(flag == 0)
			{
				for(i = courses; i.next != null; i = i.next);
				i.next = new CourseNode(temp);
			}
		}
	}

	void removeCourse() throws IOException {
		int flag = 0;
		String temp;
		CourseNode i = courses;
		CourseNode preNode = courses;
			
		System.out.print("Enter course name to remove:");
		temp = br.readLine();
		if(i.name.equals(temp)){ // if course to remove is the first course in list		
			
			courses = courses.next;
			flag = 1;
		}	
		else if(i.next != null){		
			for(i = courses.next; i.next != null; i = i.next){
				
				if(i.name.equals(temp))
				{
					preNode.next = i.next;
					flag = 1;
				}
				preNode = i;
			}
		}


		if(flag == 0)
			System.out.println("Course not found.");
		else
			System.out.println("Course removed");

	}
	
	void displayDetails(){
		System.out.println("Name : " + this.name);
		System.out.println("Address : " + this.address);
		if(courses != null){
			System.out.println("Courses list.");
			
			for(CourseNode i = courses; i != null; i = i.next){
				System.out.println(i.name);
			}
		}
	}


}

public class Q1{

	public static void main(String[] args ) throws IOException {

		int choice;
		Student s = null;
		Teacher t = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do{
			System.out.print("Enter your choice\n\t1.Student related operations\n\t2.Teacher related operations\n\t3.Exit\n>>>");
			choice = Integer.parseInt(br.readLine());

			switch(choice){
				case 1:
					do{
						System.out.print("Enter your choice\n\t1.Add student details\n\t2.Display details\n\t3.Exit\n>>>");
						choice = Integer.parseInt(br.readLine());
						switch(choice){
							case 1:
								s = new Student();
								break;

							case 2:
								if(s == null)
									System.out.println("Please enter student details first.");
								else
									s.displayDetails();
								break;
							case 3:
								choice = 103;
							default:
								System.out.println("choose correct choice");
						}
					}while(choice != 103);
				break;
				case 2:
					
					do{
						System.out.print("Enter your choice\n\t1.Add teacher details\n\t2.Add course\n\t3.Remove course\n\t4.Show teacher details\n\t5.Exit\n\t>>>");
						choice = Integer.parseInt(br.readLine());
						switch(choice){
							case 1:
								t = new Teacher();
								break;
							case 2:
								if(t == null)
									System.out.println("Enter teacher deails first");
								else{
									t.addCourse();
									t.displayDetails();
								}
								break;

							case 3:
								if(t == null)
									System.out.println("Enter teacher deails first");
								else{
									if(t.courses == null)
										System.out.println("No course found");
									else
										t.removeCourse();
								}
								break;
							case 4:
								if(t == null)
									System.out.println("Enter teacher deails first");
								else
									t.displayDetails();
								break;
							case 5:
								choice = 205;
							default:
								System.out.println("Enter correct choice.");
						}
					}while(choice != 205);
					break;
				case 3:
					choice = 3;
					break;
				default:
					System.out.println("Enter correct choice");
			}
		}while(choice != 3);
	}
}
