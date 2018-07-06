import java.net.*;
import java.io.*;

public class Server{
	public static void main(String []args) throws Exception {
		ServerSocket ss = new ServerSocket(1212);
		Socket s = ss.accept();
		
		DataInputStream dis = new DataInputStream(s.getInputStream());
		
		String str = dis.readUTF();
		System.out.println(str);
		
		dis.close();
		s.close();
		ss.close();
	}
}
