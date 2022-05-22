import java.io.*;
import java.util.*;
import java.net.*;

class Client{
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("localhost", 4000);
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        System.out.print("Enter number :");
        out.writeUTF((new Scanner(System.in).nextLine()));

    }
}