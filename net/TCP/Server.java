import java.net.*;
import java.io.*;

public class Server{
  public void init(){
    
  }
  public static void main(String [] args) throws Exception{
    ServerSocket ss = new ServerSocket(1235);
    Socket s = ss.accept();
    DataOutputStream dos = new DataOutputStream(s.getOutputStream());
    DataInputStream dis = new DataInputStream(s.getInputStream());

    while(true){
      String msg = dis.readUTF();
      System.out.println(msg);
      if(msg.equals("bye"))
        break;
    }


    dos.close();
    dis.close();
    s.close();
    ss.close();

  }
}
