// write program to define a class item(item_code, name, price, & quantity). 
// 1. Define default & parameterize constructors. 
// 2. Accept details from user, calculate total price of all items
// 3. Display details of item entered by user as well as sort all the items on the basis of cost


import java.util.Scanner;
import java.io.*;

class Item{
	int item_code, quantity;
	float price;
	String name;
	
	static int code = 0;

	Item(String name, float price, int quantity){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.item_code = ++code;   //useing static variable 
	}
	
	//calculate cost of a items
	float calculateCost(){
		return this.price * this.quantity;
	}
	
	//******STATIC METHODS******

	//method to accept items
	static Item[] acceptItems() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int quantity, totalItemsCount;
		float price;
		String name;
		System.out.print("How many items you want to add : ");
		totalItemsCount = Integer.parseInt(br.readLine());
		Item[] items = new Item[totalItemsCount];
		  
		for(int i = 0; i < totalItemsCount; i++){
			System.out.print("\nEnter item name : ");
			name = br.readLine();
			System.out.print("\nEnter price : ");
			price = Float.parseFloat(br.readLine());
			System.out.print("\nEnter quantity : ");
			quantity = Integer.parseInt(br.readLine());

			//creating item object
			items[i] = new Item(name, price, quantity);
		} 
		return items;
	}

	//method to calculate price of all items
	static float calculateTotalPrice(Item[] items){
		float totalPrice = 0f;
		for(int i = 0; i < items.length; i++){
			totalPrice += items[i].calculateCost(); 
		}		
		return totalPrice;
	
	}

	//method to sort(insertion sort) 
	static void sortItems(Item[] items){
		int j=0;
		Item tempItem;
		for(int i = 1; i < items.length; i++){
			tempItem  = items[i];
			j = i-1;
			while(j >= 0 && items[i].calculateCost() < items[j].calculateCost()){
				items[j+1] = items[j];
				j--;
			}
			items[j+1] = tempItem;
		}	
	}

	//method to print all records
	static void printItems(Item[] items){
		System.out.println("All records \nName  \tPrice\tquantity\tcost");
		for(int i = 0; i < items.length; i++){
		System.out.println(items[i].name +"   "+ items[i].price +"   "+ items[i].quantity+"   "+ items[i].calculateCost());
		}
	}


}


public class Q4{
	public static void main(String[] args) throws IOException{
		
		Item[] items = Item.acceptItems(); 

		float totalPrice = Item.calculateTotalPrice(items);
		Item.printItems(items);
		System.out.println("Total price of items : "+totalPrice);
		System.out.println("After Sorting");
		Item.sortItems(items);
		Item.printItems(items); 
	}
}
