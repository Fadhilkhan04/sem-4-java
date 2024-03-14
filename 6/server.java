import java.io.*;
import java.net.*;

class server {
  public static void main(String[] args) {
    try {
      String str;
      ServerSocket server = new ServerSocket(6555);
      Socket s = server.accept();
      BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
      str = br.readLine();
      Runtime r = Runtime.getRuntime();
      Process p = r.exec(args);
      server.close();
    } catch (IOException e) {
      System.out.println("Error");
    }
  }
}