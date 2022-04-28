import java.io.*;
import java.net.*;


public class Server{
    public static void main(String[] args) throws UnknownHostException, IOException{
        ServerSocket ss = new ServerSocket(4444);

        System.out.println("Server started.");

        Socket s = ss.accept();
        System.out.println("Connected to client.");

        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        DataInputStream in = new DataInputStream(s.getInputStream());

        String question = "2-2 = ?";
        String answer = "0";
        int i = 0;
        int marks = 0;
        while(i < 10)
        {
            out.writeUTF(question);
            i++;
            if(answer.equalsIgnoreCase(in.readUTF()))
                marks++;
        }

        out.writeUTF("Marks :"+ marks);

    }
}