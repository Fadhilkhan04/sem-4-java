import java.io.*;
import java.net.*;

class client {

  public static void main(String[] args) {

    try {
      String str;
      Socket client = new Socket("localhost", 6555);
      PrintStream ps = new PrintStream(client.getOutputStream());
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      str = br.readLine();
      ps.println(str);
      client.close();

    } catch (IOException e) {
      System.out.println("error");
    }
  }
}