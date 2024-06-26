import java.io.*;
import java.net.Socket;

public class client {
  private static DataOutputStream dataOutputStream = null;
  private static DataInputStream dataInputStream = null;

  public static void main(String[] args) {

    try {
      Socket socket = new Socket("localhost", 900);
      dataInputStream = new DataInputStream(socket.getInputStream());
      dataOutputStream = new DataOutputStream(socket.getOutputStream());
      System.out.println("sending the file to the server");

      sendFile("./car2.jpg");

      dataInputStream.close();
      dataOutputStream.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void sendFile(String path) throws Exception {
    int bytes = 0;

    File file = new File("./car2.jpg");
    FileInputStream fileInputStream = new FileInputStream(file);

    dataOutputStream.writeLong(file.length());

    byte[] buffer = new byte[4 * 1024];

    while ((bytes = fileInputStream.read(buffer)) != -1) {
      dataOutputStream.write(buffer, 0, bytes);
      dataOutputStream.flush();
    }
    fileInputStream.close();
    dataOutputStream.close();
  }
}