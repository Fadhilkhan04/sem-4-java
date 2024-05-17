import java.io.*;
import java.net.*;

public class server {

  private static DataInputStream din = null;
  private static DataOutputStream dout = null;

  public static void main(String[] args) {
    try {
      ServerSocket ss = new ServerSocket(6666);
      Socket s = ss.accept();
      din = new DataInputStream(s.getInputStream());
      dout = new DataOutputStream(s.getOutputStream());
      receiveFile("./receive.txt");

    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  public static void receiveFile(String fileName) throws Exception {
    int bytes = 0;
    FileOutputStream fileOutputStream = new FileOutputStream(fileName);
    long size = din.readLong();
    byte[] buffer = new byte[4 * 1024];

    while (size > 0 && (bytes = din.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {

      fileOutputStream.write(buffer, 0, bytes);
      size -= bytes;
    }
    // read file size
    System.out.println("file is received");
    fileOutputStream.close();
  }
}