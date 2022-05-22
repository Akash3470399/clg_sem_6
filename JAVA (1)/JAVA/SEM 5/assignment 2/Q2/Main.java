import series.Prime;
import series.Fibonacci;
import series.Squares;
import java.io.*;
public class Main{
	
	public static void main(String[] args) throws IOException{
		int choice;
		Prime p;
		Fibonacci f;
		Squares s;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do{
			
			System.out.println("\nWhich series you want to print : ");
			System.out.print("\t1.Prime numbers\n\t2.Fibonacci series\n\t3.Sqeres of numbers.\n\t4.Exit\n\t>>>");
			choice = Integer.parseInt(br.readLine());

			switch(choice)
			{
				case 1:
					p = new Prime();
					p.primeSeries();
					break;
				case 2:
					f = new Fibonacci();
					f.fibonacciSeries();
					break;

				case 3:
					s = new Squares();
					s.printSquares();
					break;
				case 4:
					break;
				default:
					System.out.println("Invalid choice ");	
			}

		}while(choice != 4);
	}
}
