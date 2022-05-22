import java.io.*;

abstract class Shape{
	String name;
	
	abstract void accept() throws IOException;
	abstract void display();
	abstract float area();
}

class Circle extends Shape{
	
	float r = 0;
	Circle(){
		this.name = "Circle";
	}
	void accept() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter radius size :");
		this.r = Float.parseFloat(br.readLine());	
	}

	void display(){
		System.out.println("Shape :"+this.name + "  Radius :" + this.r + "  Area :" + this.area());
	}

	float area(){
		return(float) (3.14*r*r);	
	}

}

class Square extends Shape{
	
	float h = 0, w = 0;
	
	Square(){
		this.name = "Square";
	}
	void accept() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter height of square :");
		this.h = Float.parseFloat(br.readLine());	
		System.out.println("Enter width of square :");
		this.w = Float.parseFloat(br.readLine());	

		
	}
	
	void display(){
		System.out.println("Shape :"+this.name + "  Height :" + this.h + "Width :"+ this.w +"  Area :" + this.area());
	}
	
	float area(){
		return (float)(this.w * this.h);	
	}
}

public class Q2{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Circle circle;	
		int choice;
		do{

			System.out.println("Enter your choice :\n1.Circle\n\t2.Square\n\tExit");
			choice = Integer.parseInt(br.readLine());

			switch(choice){
				case 1:
					circle = new Circle();
					circle.accept();
					circle.display();		
					break;
			}

		}while(choice != 4);
	}
}
