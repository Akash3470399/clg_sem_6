import java.io.*;
import java.net.*;


public class Client{
    public static void main(String[] args) throws UnknownHostException, IOException{
        Socket s = new Socket( "localhost" ,4444);
        System.out.println("Connected to Server.");

        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        DataInputStream in = new DataInputStream(s.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while(true)
        {
            str = in.readUTF();
            System.out.println(str);
            if(!str.contains("Marks")){
                System.out.print("Answer :");
                str = br.readLine();
                out.writeUTF(str);
            }
            else
                break;
        }

        in.close();
        out.close();
        s.close();

    }
}