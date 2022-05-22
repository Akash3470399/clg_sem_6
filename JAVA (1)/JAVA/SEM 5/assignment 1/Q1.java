// write a program to accept two integer numbers from the user & perform 
// 1. Addition
// 2. Maximum number
// 3. Print tabel

import java.util.Scanner;

public class Q1{
	public static void main(String[] args){
		int a, b, sum = 0, max;
		Scanner s = new Scanner(System.in);

		System.out.print("Enter two numbers: ");
		a = s.nextInt();
		b = s.nextInt();

		// Addition

		if(a > b)
		{
			for(int i = b; i <= a; i++){
				sum += i;
			} 
		}
		else
		{
			for(int i = a; i <= b; i++){
				sum +=i;
			}
		}
	
		System.out.println("Sum of numbers from" + a + " to " + b + " is :" + sum + "\n");
		
		// Maximum
		max = (a > b)? a: b;
		System.out.println("Maximum number is : " + max + "\n");
		
		// Tables
		System.out.println("Tables of " + a + " and " + b + "\n"); 
		for(int i = 1; i <= 10; i++){
			System.out.println("\t" + a*i +"\t" + b*i);
		}  
	}
}
