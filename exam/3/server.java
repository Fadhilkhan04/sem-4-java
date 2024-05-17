import java.net.*;
import java.io.*;

public class server {
  public static void main(String[] args) {

    try {
      ServerSocket ss = new ServerSocket(6666);
      Socket s = ss.accept();
      DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String msgin = "", msgout = "";

      while (!msgin.equals("end")) {
        msgin = din.readUTF();
        System.out.println("the client says:" + msgin);
        msgout = br.readLine();
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