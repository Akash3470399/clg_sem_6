package series;

import java.io.*;

public class Squares{
	
	public void printSquares() throws IOException {
	
		int n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter value of n : ");
		n = Integer.parseInt(br.readLine());
		System.out.print("\nSquares of numbers : ");
		for(int i = 1; i <= n; i++)
			System.out.print(i*i + " ");
		System.out.println("");
		
	}
}
