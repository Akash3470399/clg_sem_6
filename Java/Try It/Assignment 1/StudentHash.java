import java.util.*;
import java.io.*;

public class StudentHash {
    public static void main(String[] args)throws IOException{
        int choice;
        String name;
        float per;

        HashMap<String, Float> records = new HashMap<String, Float>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.print("Enter your choice\n\t1.Add student\n\t2.Display\n\t3.Search\n\t4.Find out highest.\n\t5.Exit\n\t>>>");
            choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter student name:");
                    name = br.readLine();
                    System.out.print("Enter percentages :");
                    per = Float.parseFloat(br.readLine());
                    records.put(name, per);
                    break;

                case 2:
                    System.out.println("Records :" + records);
                    break;

                case 3:
                    System.out.print("Enter student name to search :");
                    name = br.readLine();
                    if(records.get(name) != null)
                        System.out.println("Yes " + name + " is present in records.");
                    else
                        System.out.println("No " + name + " is not present.");
                    break;

                case 4:
                    float maxPer = Collections.max(records.values());

                    for(String n: records.keySet()){
                        per = records.get(n);
                        if(per == maxPer)
                            System.out.println(n + " Have hignest score, i.e. " + maxPer);
                    }

                case 5:
                    break;
            
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 5);

    }
}
