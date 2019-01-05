import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

import java.io.IOException;
import java.net.SocketException;

public class Client{
  public static void main(String [] args){
    String filename = null;
    byte[] fbytes = null;
    InetAddress ip = null;
    DatagramPacket dp = null;
    DatagramSocket ds = null;
    Scanner sc = null;

    //get local ip
    try{ip = InetAddress.getLocalHost();}catch(Exception e){System.out.println(e);}

    //init DatagramSocket
    try{ds = new DatagramSocket();}catch(SocketException se){System.out.println(se);}

    //init scanner object
    sc = new Scanner(System.in);


    //get file name from user
    System.out.print("Enter file name: ");
    filename = sc.nextLine();

    //pass file name to server
    //create DatagramPacket object & pacl it with Data
    fbytes = filename.getBytes();
    dp = new DatagramPacket(fbytes, fbytes.length, ip, 1235);

    try{ds.send(dp);}catch(IOException e){System.out.println(e);}



    //read data sent from server










    //close ds
    try{ds.close();}catch(Exception e){System.out.println(e);}
  }
}
