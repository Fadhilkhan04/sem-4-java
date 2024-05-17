import java.io.*;
import java.net.*;

public class server {

  private static DataInputStream din = null;
  // private static DataOutputStream dout = null;

  public static void main(String[] args) {
    try {
      ServerSocket ss = new ServerSocket(6666);
      Socket s = ss.accept();
      din = new DataInputStream(s.getInputStream());
      // dout = new DataOutputStream(s.getOutputStream());
      receiveFile("./receive.txt");

    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  public static void receiveFile(String fileName) throws Exception {
    int bytes;
    FileOutputStream fis = new FileOutputStream(fileName);
    long size = din.readLong();
    byte[] buffer = new byte[4 * 1024];

    do {
      bytes = din.read(buffer);
      // bytes = din.read(buffer, 0, (int) Math.min(buffer.length, size));
      fis.write(buffer, 0, bytes);
      // size -= bytes;
    } while (size > 0 && bytes != -1);
    // read file size
    System.out.println("file is received");
    fis.close();
  }
}