import java.util.*;
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


class StudInfo<T, U, V>{
		int rno;
		String nm;
		float mrk;
		T attendence;
		U DOB;
		V phNo;
	
	public StudInfo(){
		rno=0;
		nm=null;
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
	
	void setRno(int rno){
		this.rno=rno;
	}
	void setNm(String nm){
		this.nm=nm;
	}
	void setMrk(float mrk){
		this.mrk=mrk;
	}
	
	void setAttendence(T at){
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
		return phNo;
	}
}

public class StuDB{

	StudInfo<Float, String, Long> si = new StudInfo <Float, String, Long>();
	Client c;
	
	StuDB(){
		c = new Client();
		c.init();
	}
	
	void insert(){
		Scanner sc=new Scanner(System.in);  
				 
		System.out.println("Enter your rollno");  
		si.setRno(sc.nextInt());  
		System.out.println("Enter your name");      
		sc.next();
		si.setNm(sc.nextLine());  
		System.out.println("Enter your marks");  
		si.setMrk(sc.nextFloat());
		System.out.println("Enter your attendence");  
		si.setAttendence(sc.nextFloat());
		System.out.println("Enter your DOB");  
		sc.next();
		si.setDOB(sc.nextLine());
		System.out.println("Enter your ph no");  
		si.setPhNo(sc.nextLong());


		String str =si.getInt()+","+si.getNm()+","+si.getMrk()+","+si.getAttendence()+","+si.getPhNo());  
		c.write(str);
	}
	
	public static void main(String []args){
		StuDB s = new StuDB();
		s.insert();
	}
}
