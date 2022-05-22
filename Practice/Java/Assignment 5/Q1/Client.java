import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args){
        try{
            Socket s = new Socket("localhost", 4000);
            System.out.println(s.getInetAddress());

            DataInputStream in = new DataInputStream(s.getInputStream());
            System.out.println(in.readUTF());
        }
        catch(Exception e){}
    }
    
}
