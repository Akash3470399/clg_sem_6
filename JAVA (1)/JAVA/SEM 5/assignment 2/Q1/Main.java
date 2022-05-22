import MATRIX.A2Q1a;
import MATRIX.A2Q1b;
import MATRIX.A2Q1c;
import java.io.*;
public class Main{
	
	public static void main(String[] argv) throws IOException{
		int choice, data;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do
		{
			System.out.println("Choose operation from bellow :");
			System.out.print("1.Accept and display matrix\n\t2.Addition of matrix\n\t3.Find maximum of matrix elements\n\t4.Exit\n\t>>>");
			choice = Integer.parseInt(br.readLine());

			switch(choice)
			{
				case 1:
					A2Q1a A = new A2Q1a();
					A.acceptMatrix();
					A.displayMatrix();
					break;
				case 2:
					A2Q1b B = new A2Q1b();
					B.addition();
					break;
				case 3:
					A2Q1c C = new A2Q1c();
					data = C.maximum();
					System.out.println("Maximum element is : " + data);
					break;
				case 4:
					break;

				default:
					System.out.println("Invalid choice");
			}
		}while(choice != 4);
	}
}
