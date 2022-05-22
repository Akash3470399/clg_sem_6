package ds;

class QueueNode{
	int data;
	QueueNode next;

	QueueNode(int data)
	{
		this.data = data;
		this.next = null;
	}	
}

public class Queue{
	QueueNode front, rear;

	public Queue(){
		front = null;
		rear = null;
	}

	public void enqueue(int data){
		QueueNode newNode = new QueueNode(data);
		if(rear == null){
			rear = newNode;
			front = newNode;
		}	
		else{	
			rear.next = newNode;
			rear = newNode;
		}
	}

	public int dequeue(){
		int data = front.data;
		front = front.next;
		if(front == null)
			rear=null;
		return data;
	}
	public void display(){
		QueueNode temp = front;
	
		while(temp != null){
			System.out.print(" "+temp.data);
			temp = temp.next;
		}
	}

	public boolean isEmpty(){
		if(front == null)
			return true;
		return false;
	}

	public void displayQueue(){
		QueueNode ptr = front;
		System.out.print("Queue containt. :");
		while(ptr != null)
		{
			System.out.print(ptr.data + " ");
			ptr = ptr.next;
		}
		System.out.println("");
	}
}






