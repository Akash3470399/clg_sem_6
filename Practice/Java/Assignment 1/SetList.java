import java.io.*;
import java.util.*;

public class SetList{
    public static void main(String[] args)throws IOException{
        int n, num;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> a = new LinkedList<Integer>();
        LinkedList<Integer> b = new LinkedList<Integer>();
        LinkedList<Integer> union = new LinkedList<Integer>();
        LinkedList<Integer> intersection = new LinkedList<Integer>();

        System.out.print("Enter n");
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            System.out.print("Enter number :");
            num = Integer.parseInt(br.readLine());
            if(a.contains(num) && b.contains(num))
                continue;
            else if(a.contains(num))
                b.add(num);
            else    
                a.add(num);
        }

        System.out.println("A:" + a +"\nB:"+ b);

        for(int i = 0; i < a.size(); i++)
        {
            if(b.contains(a.get(i)))
                intersection.add(a.get(i));
        }
        System.out.println("intersection :" + intersection);
        
        union.addAll(a);

        for(int i = 0; i < b.size(); i++){
            if(!union.contains(b.get(i)))
                union.add(b.get(i));
        }
        System.out.println("Union :" + union);
    }
}