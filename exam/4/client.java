import java.net.*;
import java.io.*;
import java.util.*;

public class client {

  public static void main(String[] args) {
    try {
      String str;
      Socket s = new Socket("localhost", 6666);
      // PrintStream ps = new PrintStream(s.getOutputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());
      // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      Scanner a = new Scanner(System.in);
      System.out.println("enter command");
      str = a.nextLine();
      dout.writeUTF(str);
      // ps.println(str);
      s.close();
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}