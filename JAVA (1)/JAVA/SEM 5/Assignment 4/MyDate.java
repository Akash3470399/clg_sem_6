import java.util.Scanner;

class InvalidDateException extends Exception{
	InvalidDateException(String errMsg){
		System.out.println(errMsg);
	}
}

class MyDate{
	int dd, mm, yy;
	
	void accept(){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter year :");
		yy = sc.nextInt();

		System.out.print("Enter month :");
		mm = sc.nextInt();

		System.out.print("Enter date :");
		dd = sc.nextInt();
	}

	public static void main(String[] args){
		MyDate date = new MyDate();
		date.accept();
		try{
			date.validate();
			date.display();
		}
		catch(InvalidDateException e){
			
		}
	}	

	// accepts date & return true if date is valid
	boolean validate() throws InvalidDateException{
		
		if(yy > 0){
			
			switch(mm){
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					if(dd < 1 || dd > 31)
						throw new InvalidDateException("ERROE : Check Date.");
					break;

				case 2:
					if(yy % 4 == 0 && (dd < 0 || dd > 29))
						throw new InvalidDateException("ERROR : Check date for leap year");
					else if(yy % 4 != 0 && (dd < 0 || dd > 28))
						throw new InvalidDateException("ERROR : Check date.");
			
					break;
				
				case 4: case 6: case 9: case 11:
					if(dd < 1 || dd > 30)
						throw new InvalidDateException("ERROR : Check date");
					break;
				default:
					throw new InvalidDateException("ERROR : Check month ");
			
			}
		}
		else
			throw new InvalidDateException("ERROR : Check year.");

		return true;
	}

	void display(){
		
		System.out.println("Date : " + dd + "/" + mm + "/" +yy);
	}
}
