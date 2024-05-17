import java.io.*;
import java.net.*;

public class server {
  private static DataInputStream din = null;

  public static void main(String[] args) {
    try {
      ServerSocket ss = new ServerSocket(6666);
      Socket s = ss.accept();
      din = new DataInputStream(s.getInputStream());
      receiveFile("./receive1.txt");
      ss.close();
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  public static void receiveFile(String fileName) throws Exception {

    int bytes;
    FileOutputStream fout = new FileOutputStream(fileName);
    long size = din.readLong();
    byte[] buffer = new byte[4 * 1024];

    do {
      bytes = din.read(buffer, 0, (int) Math.min(size, buffer.length));
      fout.write(buffer, 0, bytes);
      size -= bytes;
    } while (size > 0 && bytes != -1);
    fout.close();
    System.out.println("received successfully");
  }
}