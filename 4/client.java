import java.io.*;
import java.net.*;
import java.util.*;

public class client {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        try {
            Socket s = new Socket("localhost", 6666);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(a.nextLine());
            dout.flush();
            dout.close();
            s.close();
            a.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}