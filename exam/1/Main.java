import java.net.*;
import java.io.*;

public class Main {

  public static void sendPingRequest(String ipAddress) throws UnknownHostException, IOException {
    InetAddress ip = InetAddress.getByName(ipAddress);
    System.out.println("sending ping request:" + ipAddress);
    if (ip.isReachable(5000))
      System.out.println("host is reachable");
    else
      System.out.println("host is not reachable");
  }

  public static void main(String[] args) throws UnknownHostException, IOException {

    String ipAddress = "127.0.0.1";
    sendPingRequest(ipAddress);
    ipAddress = "104.244.42.129";
    sendPingRequest(ipAddress);
    ipAddress = "52.71.87.55";
    sendPingRequest(ipAddress);

  }
}