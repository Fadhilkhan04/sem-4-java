import java.net.*;
import java.io.*;

public class client {
  private static DataInputStream din = null;
  private static DataOutputStream dout = null;

  public static void main(String[] args) {
    try {
      Socket s = new Socket("localhost", 6666);
      din = new DataInputStream(s.getInputStream());
      dout = new DataOutputStream(s.getOutputStream());
      System.out.println("sending file to server");
      sendFile("./test.txt");
      s.close();
      din.close();

    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  public static void sendFile(String path) throws Exception {

    int bytes = 0;
    File f = new File("./test.txt");
    FileInputStream fis = new FileInputStream(f);
    dout.writeLong(f.length());
    byte[] buffer = new byte[4 * 1024];

    do {
      bytes = fis.read(buffer);
      dout.write(buffer, 0, bytes);
      dout.flush();
    } while (bytes != -1);
    fis.close();
  }
}
