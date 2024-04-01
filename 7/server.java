import java.io.*;
import java.net.*;

public class server {

  private static DataInputStream dataInputStream = null;
  private static DataOutputStream dataOutputStream = null;

  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(900)) {
      Socket clientSocket = serverSocket.accept();

      System.out.println("connected");
      dataInputStream = new DataInputStream(clientSocket.getInputStream());
      dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
      receiveFile("./test.txt");
      dataInputStream.close();
      dataOutputStream.close();
      clientSocket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // receive file function
  private static void receiveFile(String fileName) throws Exception {

    int bytes = 0;
    FileOutputStream fileOutputStream = new FileOutputStream(fileName);
    long size = dataInputStream.readLong();
    byte[] buffer = new byte[4 * 1024];

    while (size > 0 && (bytes = dataInputStream.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {

      fileOutputStream.write(buffer, 0, bytes);
      size -= bytes;
    }
    // read file size
    System.out.println("file is received");
    fileOutputStream.close();
  }
}