import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.net.SocketException;
import java.io.IOException;

public class Server{
  public static void main(String [] args) throws IOException{
    // create DatagramSocket to listen at port 1235
    DatagramSocket ds = new DatagramSocket(1235);
    byte[] receive = new byte[65535];
    DatagramPacket dp = null;

    while(true){
      // create DP to receive Data
      dp = new DatagramPacket(receive, receive.length);

      //receive data in byte buffer
      ds.receive(dp);
      String str = data(receive).toString();
      //print data sent by client

      System.out.println("Client: "+ str);

      if(str.equals("bye")){
        System.out.println("exiting...");
        break;
      }
      // clear buffer after every message
      receive = new byte[65535];
    }
  }

  //method: data , to convert bytes into chars
  public static StringBuilder data(byte[] receive){
    if(receive == null)
      return null;

    StringBuilder res = new StringBuilder();
    int i = -1;
    while(receive[++i] != 0){
      res.append((char)receive[i]);
    }
    return res;
  }

}
