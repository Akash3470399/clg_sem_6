package series;

import java.io.*;

public class Prime{
	int num;

	public void primeSeries() throws IOException{
		int count = 0, n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter value of n : ");
		n = Integer.parseInt(br.readLine());

		System.out.println("Prime Numbers");
		for(int i = 1; count <= n; i++)
		{
			if(isPrime(i))
			{	System.out.print(i + "  ");
				count++;
			}
		}
		
	}

		
	public boolean isPrime(int data)
	{
		int count = 0;
		for(int i = 1; i <= data; i++)
		{
			if(data % i == 0)
				count++;
		}
		if(count == 2)
			return true;
		else
			return false;
	}
				
}
