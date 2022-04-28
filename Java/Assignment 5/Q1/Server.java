import java.io.*;
import java.net.*;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Server {
    public static void main(String[] args)throws UnknownHostException, IOException{
        ServerSocket ss = new ServerSocket(4000);

        System.out.println("Server started.");

        Socket s = ss.accept();
        System.out.println("Connected to client.");

        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time_ = dtf.format(now);
        out.writeUTF(time_);

        out.close();
        s.close();
        ss.close();
    }
}
