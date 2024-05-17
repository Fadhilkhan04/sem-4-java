import java.net.*;
import java.io.*;

public class server {

  public static void main(String[] aargs) {

    try {
      ServerSocket ss = new ServerSocket(6666);
      Socket s = ss.accept();
      DataInputStream dis = new DataInputStream(s.getInputStream());
      String str = dis.readUTF();
      System.out.println("the message from client is:" + str);

      ss.close();
    } catch (Exception e) {
      System.out.println("sorry there has been an errro:" + e);
    }
  }
}