import java.net.*;
import java.io.*;
import java.util.*;

public class server {
  public static void main(String[] args) {

    try {
      ServerSocket ss = new ServerSocket(6666);
      Socket s = ss.accept();
      DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());
      Scanner a = new Scanner(System.in);
      // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String msgin = "", msgout = "";

      while (!msgin.equals("end")) {
        msgin = din.readUTF();
        System.out.println("the client says:" + msgin);
        msgout = a.nextLine();
        dout.writeUTF(msgout);
        dout.flush();

      }

      ss.close();
      s.close();
    } catch (Exception e) {
      System.out.println("error:" + e);
    }
  }
}