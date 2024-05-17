import java.io.*;
import java.net.*;

public class client {
  private static DataOutputStream dout = null;

  public static void main(String[] args) {
    try {
      Socket s = new Socket("localhost", 6666);
      dout = new DataOutputStream(s.getOutputStream());
      System.out.println("sending the file to server");
      sendFile("./test1.txt");
      s.close();
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  private static void sendFile(String path) throws Exception {
    int bytes;
    // File f = new File("./test1.txt");
    FileInputStream fis = new FileInputStream(path);
    int size = (int) path.length();
    dout.writeLong(size);
    byte[] buffer = new byte[4 * 1024];

    do {
      bytes = fis.read(buffer, 0, (int) Math.min(size, buffer.length));
      dout.write(buffer, 0, bytes);
      size -= bytes;
    } while (size > 0 && bytes != -1);
    fis.close();
    System.out.println("file send succeessfully");
  }
}