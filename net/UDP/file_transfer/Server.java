import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;

import java.io.IOException;
import java.net.SocketException;

public class Server{
  public static void main(String[] args){
    DatagramSocket ds = null;
    DatagramPacket dp = null;
    String filename = null;
    byte[] fbytes = null;

    //init DatagramSocket
    ds = new DatagramSocket(1235);
    fbytes = new byte[65535];

    //int DatagramPacket
    dp = new DatagramPacket(fbytes, fbytes.lenght);

    //receive DatagramPacket
    ds.reveice(dp);
    
  }
}
