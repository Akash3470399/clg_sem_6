import java.util.Scanner;

class NumArr{
  public static void main(String[] args){
    
    int n = 0;
    int[] arr;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter size of array :");
    n = sc.nextInt();
    arr = new int[n];

    for(int i = 0; i < n; i++){
      System.out.print("Enter element " + (i+1) + " :");
      arr[i] = sc.nextInt();
    }

   
    try{
	System.out.print("Enter index to access element :");
	n = sc.nextInt();
      	System.out.println("Value at index "+ n + " is "+ arr[n]);
    }
    catch(ArrayIndexOutOfBoundsException e){
	System.out.println(e);
    }

  }
}
