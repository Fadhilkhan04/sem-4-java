import java.net.*;
import java.io.*;

public class server {

  public static void main(String[] args) {

    try {
      String str;
      ServerSocket ss = new ServerSocket(6666);
      Socket s = ss.accept();
      DataInputStream din = new DataInputStream(s.getInputStream());
      // BufferedReader br = new BufferedReader(new
      // InputStreamReader(s.getInputStream()));
      str = din.readUTF();
      Runtime r = Runtime.getRuntime();
      Process p = r.exec(str);
      ss.close();
      s.close();

    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}