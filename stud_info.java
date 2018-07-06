import java.util.*;
import java.net.*;
import java.io.*;

class Server{
	
	ServerSocket ss;
	Socket s;
	DataInputStream dis;
	
	void init() throws Exception {
		ss = new ServerSocket(1212);
		s = ss.accept();
	
		dis = new DataInputStream(s.getInputStream());
	}
	
	void read(){		
		String str = dis.readUTF();
		System.out.println(str);
	}
	
	void close(){
		dis.close();
		s.close();
		ss.close();
	}
}

class StudInfo<T, U, V>{
		int rno;
		Strign nm;
		double mrk;
		T attendence;
		U DOB;
		V phNo;
	
	public StudInfo(){
		rno=0;
		nm=NULL;
		mrk=0;
	}
	public StudInfo(int rno){
		this.rno=rno;
	}
	public StudInfo(String nm){
		this.nm=nm;
	}
	public StudInfo(float mrk){
		this.mrk=mrk;
	}
	public StudInfo(int rno, String nm, float mrk){
		this.javaProg(rno);
		this.javaProg(nm);
		this.javaProg(mrk);
	}
	
	void setRno(int rno){
		this.rno=rno;
	}
	void setNm(String nm){
		this.nm=nm;
	}
	void setMrk(float mrk){
		this.mrk=mrk;
	}
	void set(int rno, String nm, float mrk){
		this.javaProg(rno);
		this.javaProg(nm);
		this.javaProg(mrk);
	}
	
	void setAttendence(T atrno){
		attendence = at;
	}
	void setDOB(U dob){
		DOB = dob;
	}
	void setPhNo(V pn){
		phNo = pn;
	}
	
	int getInt(){
		return rno;
	}
	
	String getNm(){
		return nm;
	}
	
	float getMrk(){
		return mrk;
	}
	
	T getAttendence(){
		return attendence;
	}
	
	U getDOB(){
		return DOB;
	}
	
	V getPhNo(){
		return phNO;
	}
}

public class StuDB{
	LinkedList<StudInfo> vstu = new LinkedList<StudInfo>();
	StudInfo si = new StudInfo();
	Server ss;
	
	StuDB(){
		ss = new Server();
	}
	void add(){
		String str = ss.readUTF();  
	}
	
	public static void main(String []args){
		StuDB s;
		s.insert();
	}
}
