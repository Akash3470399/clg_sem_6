import ds.Queue;
import ds.Stack;
import java.io.*;

public class Main{
 	
	public static String reverseStr(String str){

                Stack stack = new Stack();
                char[] strArr = str.toCharArray();
                char[] reverseStr;
                int i = 0;

                for(i = 0; i < strArr.length; i++)
                        stack.push(strArr[i]);  // push each char to stack
			
                i = 0;
		;
                while(!stack.isEmpty())
                {
                        strArr[i] = stack.pop();
                        i++;
                }

                return new String(strArr);

        }

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		int choice = 0;
		String str, revStr;
	
		do{
			System.out.println("Enter your choice :\n\t1.Reverse a string \n\t2.Queue operations\n\t3.Exit\n\t>>>\b");
			choice = Integer.parseInt(br.readLine());

			switch(choice){

				case 1:
					System.out.print("Enter string to reverse : ");
					str = br.readLine();
					
					revStr = reverseStr(str);
					System.out.println("Reverse string is : "+ revStr);
					break;
				case 2:
					queueOperations();
					break;
				case 3:
					choice = 3;
					break;
				default:
					System.out.println("Please enter correct choice.");
			}
			
		}while(choice != 3);	
	}


	public static void queueOperations() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue queue = new Queue();
		int choice = 0, data;
		do{
			System.out.println("Which operation to perform \n\t1.Add\n\t2.Delete\n\t3.Display\n\t4.Exit\n\t>>>\b");
                        choice = Integer.parseInt(br.readLine());
                        switch(choice){
				case 1:
					System.out.print("Enter data :");
					data = Integer.parseInt(br.readLine());

					queue.enqueue(data);
					break;
				case 2:
					if(!queue.isEmpty())
						System.out.println("Data deleted : " + queue.dequeue());
					else
						System.out.println("Queue is empty.");
					break;
				case 3:
					if(!queue.isEmpty())
						queue.displayQueue();
					else
						System.out.println("Queue is empty.");
							
		        }
		}while(choice != 4);

	}

}












