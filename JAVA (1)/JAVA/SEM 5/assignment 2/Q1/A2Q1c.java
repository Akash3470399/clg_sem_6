package MATRIX;

import MATRIX.A2Q1a;
import java.io.*;
public class A2Q1c{
	A2Q1a A;

	public A2Q1c() throws IOException{
		A = new A2Q1a();
		A.acceptMatrix();
		A.displayMatrix();
	}

	// function returns maximum element from the matrix
	public int maximum()
	{
		int max = A.matrixArr[0][0];

		for(int i = 0 ; i < A.row; i++)
		{
			for(int j = 0; j < A.col; j++)
			{
				if(A.matrixArr[i][j] > max)
					max = A.matrixArr[i][j];
			}
		}
		return max;
	}
}
