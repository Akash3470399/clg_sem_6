import java.io.*;
import java.net.*;

class Server{
    public static void main(String[] args){
            try{
        ServerSocket ss = new ServerSocket(4000);
        System.out.println("Server started.");

        Socket s = ss.accept();
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        DataInputStream in = new DataInputStream(s.getInputStream());

        String fileName = in.readUTF();
        System.out.print(fileName);

        File f = new File("./files/" + fileName);

        if(f.exists() && !f.isDirectory()){

            BufferedReader fin = new BufferedReader(new FileReader(f));
            String str;
            while((str = fin.readLine()) != null)
                out.writeUTF(str);

            out.writeUTF("exit");
        }
        else{
            out.writeUTF("File does not exits.");
            out.writeUTF("exit");
        }
    }
    catch(Exception e){}
}
    }
