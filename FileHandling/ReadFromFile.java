import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import java.io.IOException;


public class ReadFromFile{
  public static void main(String[] args){
    File file = null;
    FileReader fr = null;
    Scanner sc = null;
    String filename = null;
    int c = 0;

    //init Scanner with System.in
    try{sc = new Scanner(System.in);}catch(Exception e){System.out.println(e);}

    //get file name to read from user
    System.out.println("Enter file name: ");
    filename = sc.nextLine();

    //init File object with given file filename
    try{file = new File(filename);}catch(Exception e){System.out.println(e);}

    // check file exist or not
    if(file.exists())
      System.out.println("file exist");
    else
      System.out.println("file not found");

    // init file reader with file
    try{fr = new FileReader(file);}catch(Exception e){System.out.println(e);}

    //read data from file
    System.out.println("file data:");
    while(true){
      try{c = fr.read();}catch(Exception e){System.out.println(e);}
      if(c == -1)
        break;
      System.out.print((char)c);
    }

    //close file FileREader
    try{fr.close();}catch(Exception e){System.out.println(e);}
  }
}
