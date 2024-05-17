import java.net.*;
import java.io.*;
import java.util.*;

public class client {

  public static void main(String[] args) {
    try {
      Socket s = new Socket("localhost", 6666);
      Scanner a = new Scanner(System.in);
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());
      dout.writeUTF(a.nextLine());
      dout.flush();
      s.close();
      a.close();
    } catch (IOException e) {
      System.out.println(e);
    }

  }
}