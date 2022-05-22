package series;

import java.io.*;

public class Fibonacci{
	
	public void fibonacciSeries() throws IOException{
		
		int a = 0,b = 1, count = 2, c, n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter value of n : ");
		n = Integer.parseInt(br.readLine());
		
		System.out.print("Fibonacci series : "+ a + " " + b + " ");
		while(count < n)
		{
			c = a + b;
			a = b;
			b = c;
			System.out.print(c+" ");
			count++;
		}
		System.out.println("");
		
	}
}
