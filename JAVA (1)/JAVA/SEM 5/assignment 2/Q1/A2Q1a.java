// class to create accept & display the matrix
package MATRIX;

import java.io.*;


public class A2Q1a{
	int matrixArr[][];
	int col, row;
	
		
	public A2Q1a() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("How many row are there in your matrix (m) : ");
		row = Integer.parseInt(br.readLine());
		System.out.println("How many columns are there in your matrix (n) : ");
		col = Integer.parseInt(br.readLine());

		matrixArr = new int[row][col];  
	}

	// constructor to create a matrix filled each element as data(x) 
	public A2Q1a(int r, int c,int x){
		
		row = r;
		col = c;

		matrixArr = new int[row][col];  
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
				matrixArr[i][j] = x;
		}
	}
	public void acceptMatrix() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter matrix elements.");
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{      
				System.out.print("\n Value at (" + i + ", "+ j + ") : ");
				matrixArr[i][j] = Integer.parseInt(br.readLine());
			}
		}	 
	} 

	public void displayMatrix(){
                System.out.println("Matrix : ");
                for(int i = 0; i < row; i++)
                {
                        for(int j = 0; j < col; j++)
                        {
                                System.out.print(matrixArr[i][j] + "\t"); 
                        }
			System.out.println("");
                }
        }
} 
