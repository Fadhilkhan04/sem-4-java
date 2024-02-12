import java.io.*;
import java.net.*;

public class Main {
  public static void sendPingRequest(String ipAddress) throws UnknownHostException, IOException {
    InetAddress ip = InetAddress.getByName(ipAddress);
    System.out.println("sending ping request:" + ipAddress);
    if (ip.isReachable(5000))
      System.out.println("host is reachable");
    else
      System.out.println("sorry not reachable");
  }

  // driver

  public static void main(String[] args) throws UnknownHostException, IOException {
    String ipAddress = "127.0.0.1";
    sendPingRequest(ipAddress);
    ipAddress = "34.87.74.158";
    sendPingRequest(ipAddress);
    ipAddress = "145.154.42.58";
    sendPingRequest(ipAddress);
    ipAddress = "1.1.1.1";
    sendPingRequest(ipAddress);
  }
}