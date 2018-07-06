import java.util.*;

class Student{
	int rno;
	String name;
	float mrk;
	
	Student(int rno, String name, float mrk){
		this.rno = rno;
		this.name = name;
		this.mrk = mrk;
	}
	public String tostring(){
		String s=rno+" "+name+" "+mrk;
		return s;
	}
}

class ArrayListDemo{
		
		ArrayList <Student> al = new ArrayList<Student>();
		
		void add(int rno, String name, float mrk)
		{
			al.add(new Student(rno, name, mrk));
		}
		
		void remove(String name)
		{
			al.remove(name);
		}
		
		void display()
		{
		
			System.out.println("\nStudent Data :\n");
			for(Student s: al)
				System.out.println(s.tostring());
		}
	
		static int menu()
		 {
			System.out.println(	"\nStudent DB \n1. add record\n2. delete record\n3. display:");
			Scanner sc = new Scanner(System.in);
			
			return sc.nextInt();
		}
			
			
			
			
		public static void main(String []args){
			
			Scanner sc = new Scanner(System.in);
						
			ArrayListDemo  ald = new ArrayListDemo();
			
			while(true){
				int opt = menu();
				
				switch(opt){
					case 1:
						System.out.println("\n enter roll_no\n name\n marks\n");
						int rno = sc.nextInt();
						sc.nextLine();
						String name = sc.nextLine();
						float mrk = sc.nextFloat();
						ald.add(rno, name, mrk);
						break;
					case 2:	
						System.out.println("\nEnter name : ");
						ald.remove(sc.nextline());
						break;
					case 3:
						ald.display();
				}		
			}						
		}
}
	
	
		
	
	
