import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.io.IOException;
import java.net.SocketException;

public class Client{
  public static void main(String [] args) throws IOException{
    //create DatagramSocket to send Data
    DatagramSocket ds = new DatagramSocket();
    DatagramPacket dp = null;
    InetAddress ip = InetAddress.getLocalHost();

    //byte array to hold byte Data
    byte[] data;

    //Scanner object to get data from STDIN
    Scanner sc = new Scanner(System.in);

    //loop till client not say bye
    while(true){
      String str = sc.nextLine();

      //conert strign into bytes
      data = str.getBytes();

      //create DatagramPacket to send Data
      dp = new DatagramPacket(data, data.length, ip, 1235);

      ds.send(dp);

      if(str.equals("bye"))
        break;
    }

  }
}
