// write the program to accept the string & perform
// 1. Reverse string
// 2. Length of string
// 3. alterate characters

import java.util.Scanner;

public class Q2{
	public static void main(String[] args){
		String str;
		char[] strArr;
		int len;
		Scanner s = new Scanner(System.in);

		System.out.print("Enter a string ");
		str = s.nextLine();
		
		strArr = str.toCharArray();
		len = strArr.length;
		
		// reverse string
		System.out.print("\nReverse string is : ");
		for(int i = len -1; i >= 0; i--){
			System.out.print(strArr[i]);
		}

		// length of string
		System.out.println("\nString length : " + len);

		// Alternate character
		System.out.print("Alternate character : ");
		for(int i = 0; i < len; i++){
			if(Character.isUpperCase(strArr[i])){
				System.out.print(Character.toLowerCase(strArr[i]));
			}
			else{
				System.out.print(Character.toUpperCase(strArr[i]));
			}
		} 
		System.out.println("");
	}
}
