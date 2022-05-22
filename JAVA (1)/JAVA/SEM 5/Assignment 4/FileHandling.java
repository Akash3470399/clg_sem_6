import java.io.File;
import java.util.Scanner;
import java.util.Date;
import java.text.*;
class FileHandling{

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		try{

			File f = new File(args[0]);		
			
			if(f.isDirectory()){
				File[] dirContents = f.listFiles(); // returns direcory contents & store it in subfiles File array
			
				System.out.println(f.getName() +" have "+ dirContents.length + "\nFile content. \n");
				
				for(File subfile : dirContents){
					System.out.println(subfile.getName());
				}

			
				for(int i = 0; i < dirContents.length; i++){
					File subfile = dirContents[i];
					String name = subfile.getName();
					
					if(name.contains(".txt")){
						System.out.print("Do you want to delete '"+name +"' (y/n)");
						String toDelete = sc.next();
			
						if(toDelete.equals("y") || toDelete.equals("Y")){
							subfile.delete();
						}
					}
				}
			}
			else if(f.isFile()){
			
				System.out.println("File path : "+ f.getAbsolutePath());
				System.out.println("File size : "+ f.length());
				long dateInLong = f.lastModified();
				Date date = new Date(dateInLong);
				DateFormat df = new SimpleDateFormat("dd mm yy hh:mm:ss zzz");
				System.out.println("Last modified :"+ df.format(date));
			}
	
		}
		
		finally{
			//System.out.println("file not found.");
		}
	}	
} 
