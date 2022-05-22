import java.util.*;
import java.io.*;


class Person{
    static Hashtable<String, String> persons = new Hashtable<String, String>();
    public static void main(String[] args)throws IOException{
        int n;
        String name, number;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter value of n:");
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            System.out.print("Name :");
            name = br.readLine();
            System.out.print("Number :");
            number = br.readLine();
            persons.put(name, number);
        }
        System.out.print(persons);

        System.out.print("Enter person name to search:");
        name = br.readLine();

        if(persons.contains(name))
            System.out.print("Number :" + persons.get(name));
        else
            System.out.print("Result not found.");
    }
}