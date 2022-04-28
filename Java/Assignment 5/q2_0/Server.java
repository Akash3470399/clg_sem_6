import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args){
        try {
            ServerSocket ss = new ServerSocket(4444);

            Socket client = ss.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintStream ps = new PrintStream(client.getOutputStream());
        
            
            String fileName = in.readLine();
            File f = new File(fileName);
            if(f.exists()){
                FileReader fr = new FileReader(f);
                BufferedReader br = BufferedReader(fr);
            }

            in.close();
            br.close();
            server.close();
        } catch (Exception e) {
            
        }
    }
}
