import java.io.*;
import java.net.*;

class Client{
    public static void main(String[] args){
            try{
        Socket s = new Socket("localhost", 4000);
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        DataInputStream in = new DataInputStream(s.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter file name :");
        String fileName = br.readLine();

        out.writeUTF(fileName);
        String str;
        while(true){
            str = in.readUTF();
            if(str.equals("exit"))
                break;
            else
                System.out.println(str);

        }

    }
    catch(Exception e){}
    }
}