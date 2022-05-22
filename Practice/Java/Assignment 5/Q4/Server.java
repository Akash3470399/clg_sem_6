import java.io.*;
import java.util.*;
import java.net.*;

class Server{
    public static void main(String[] args)throws IOException{
        ServerSocket ss = new ServerSocket(4000);
        System.out.println("Server Started.");
        Socket s = ss.accept();

        DataInputStream in = new DataInputStream(s.getInputStream());
        int num = Integer.parseInt(in.readUTF());
        int count = 0;
        for(int i = 1; i <= num; i++)
            if(num % i == 0)
                count++;

        if(count == 2)
            System.out.println(num + " is prime number.");
        else
            System.out.println(num + " is not prime number.");
    }       
}