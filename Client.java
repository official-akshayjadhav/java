import java.net.*;
import java.io.*;

class Client{
	 
	 DataOutputStream dos;
	 Socket s;
	 
	 void init() throws Exception
	 {
		s = new Socket("localhost",1212);
		
		dos = new DataOutputStream(s.getOutputStream());
	}
	
	void close(){
		dos.close();
		s.close();
	}
	
	void write(String str){
		dos.writeUTF(str);
	}
}

public class StuClient{
	Client c;
	c.init();

	while(true){
		
		
	}

}



