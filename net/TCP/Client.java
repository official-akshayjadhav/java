import java.net.Socket;
import java.io.*;
import java.util.*;

class ReadServer extends Thread{

  Socket socket;

  ReadServer(Socket s){
    socket = s;
  }

  public void readServer()throws Exception{
    BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    String sentence;
    while(true){
      System.out.print("waiting for server msg... ");
      sentence = serverIn.readLine();
      System.out.println(sentence);

      if(sentence.equals("bye")){

        break;
      }
    }
  }
  public void run(){
    try{readServer();}catch(Exception e){System.out.println(e);}

  }
}

class WriteServer extends Thread{

  Socket socket;

  public WriteServer(Socket s){
    socket = s;
  }

  public void writeServer()throws Exception{
    BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
    String msg = null;
    while(true){
      System.out.print("enter msg: ");
      msg = userIn.readLine();
      dos.writeUTF(msg);

      if(msg.equals("bye")){

        break;
      }
    }
    //close IO connections
    dos.close();
    userIn.close();

  }
  public void run(){
    try{writeServer();}catch(Exception e){System.out.println(e);}

  }
}

public class Client{

  Socket socket;

  public void init() throws Exception{
    socket = new Socket("localhost", 1235);
  }

  //main method
  public static void main(String []args) throws Exception{
    //create socket
    Client client = new Client();
    client.init();
    System.out.println("server connected");

    ReadServer rs = new ReadServer(client.socket);
    WriteServer ws = new WriteServer(client.socket);

    rs.start();
    ws.start();
    System.out.println("services started");
  }
}
