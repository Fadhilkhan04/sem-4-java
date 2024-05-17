import java.net.*;
import java.util.Scanner;
import java.io.*;

public class client {
  public static void main(String[] args) {

    try {

      Socket s = new Socket("localhost", 6666);
      DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());
      Scanner a = new Scanner(System.in);
      // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String msgin = "", msgout = "";

      while (!msgin.equals("end")) {
        msgout = a.nextLine();
        dout.writeUTF(msgout);
        msgin = din.readUTF();
        System.out.println("the server says:" + msgin);
        dout.flush();

      }
      s.close();
    } catch (Exception e) {
      System.out.println("error:" + e);
    }
  }
}