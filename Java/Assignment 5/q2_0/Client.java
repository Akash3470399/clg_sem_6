import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args){
        try {
            Socket server = new Socket("localhost", 4444);
            System.out.println("Client connected.");
            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintStream ps = new PrintStream(server.getOutputStream());
            System.out.println("Ener file name :");
            
            String fileName = br.readLine();
            ps.println(fileName);
            String str;
            while ((str = in.readLine()) != null)  {
                System.out.println(str);
            }

            in.close();
            br.close();
            server.close();
        } catch (Exception e) {
            
        }
    }
}
