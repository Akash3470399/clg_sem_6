package ds;

class StackNode{

	char data;
	StackNode next;

	StackNode(char data){
		this.data = data;
		this.next = null;
	}
}

public class Stack{
	
	StackNode head = null;
	

	public void push(char data){
		if(head == null)
			head = new StackNode(data);
		else{
			StackNode newNode = new StackNode(data);
			newNode.next = head;
			head = newNode; 
		}
	} 

	public char pop(){
		
		char data = head.data;
		head = head.next;
		return data;
		
	}

	public char peek(){
		return head.data;
	}

	public boolean isEmpty()
	{
		if(head == null)
			return true;
		else
			return false;
	}
}

	
