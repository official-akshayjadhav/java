import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import java.io.IOException;

public class WriteIntoFile{
  public static void main(String [] args){
    Scanner sc = null;
    File file  =null;
    FileWriter fw = null;
    //init Scanner object to System.in
    try{
      sc = new Scanner(System.in);
    }catch(Exception e){System.out.println(e);}

    // get file name from user
    System.out.print("Enter file name: ");
    String filename = sc.nextLine();

    try{
      file = new File(filename);

      if(file.createNewFile())
        System.out.println("new file created.");
      else
        System.out.println("file already exist.");
    }
    catch(IOException ioe){
      System.out.println(ioe);
    }

    // write data into File
    System.out.println("Enter Data (enter blank line to stop) :");

    //init FileWriter object with given filename
    try{fw = new FileWriter(file);}catch(IOException ioe){System.out.println(ioe);}
    while(true){
      String s = sc.nextLine();
      if(s.equals(""))
        break;

      try{fw.write(s+"\n");}catch(IOException ioe){System.out.println(ioe);}
    }

    //close file writer object
    try{fw.close();}catch(IOException ioe){System.out.println(ioe);}
  }
}
