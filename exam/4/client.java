import java.net.*;
import java.io.*;

public class client {

  public static void main(String[] args) {
    try {
      String str;
      Socket s = new Socket("localhost", 6666);
      PrintStream ps = new PrintStream(s.getOutputStream());
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("enter command");
      str = br.readLine();
      ps.println(str);
      s.close();
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}