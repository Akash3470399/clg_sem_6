import java.io.*;
import java.net.*;
import java.util.*;


public class Server {
    public static void main(String[] args){
        try{
            ServerSocket ss = new ServerSocket(4000);
            System.out.println("Server started.");
            Socket s = ss.accept();

            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            out.writeUTF((new Date()).toString());
        }
        catch(Exception e){}
    }
}
