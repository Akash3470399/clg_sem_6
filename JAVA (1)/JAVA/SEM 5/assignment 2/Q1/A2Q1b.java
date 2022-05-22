// for addition of matrix
package MATRIX;

import MATRIX.A2Q1a; // accept & display the matrix
import java.io.*;

public class A2Q1b{
	
	A2Q1a A, B, C;
	
	public A2Q1b() throws IOException
	{
		System.out.println("Matrix A ");
		A = new A2Q1a();
		A.acceptMatrix();

		System.out.println("Matrix B "); 
		B = new A2Q1a();
		B.acceptMatrix();

		C = new A2Q1a(A.row, A.col,0); // creating a extra matrix & initializing all entries to 0
		
		if((A.row != B.row) || (B.col != B.col))
		{
			System.out.println("For addition order of matrix should be same.");
			System.exit(0);
		}	  
	}
	
 	
	public void addition()
	{
		
		for(int i = 0; i < A.row; i++)
		{
			for(int j = 0; j < A.col; j++)
				C.matrixArr[i][j] = A.matrixArr[i][j] + B.matrixArr[i][j];	
		}	

		System.out.println("Addition of two matrix");
		C.displayMatrix();
	}
}



