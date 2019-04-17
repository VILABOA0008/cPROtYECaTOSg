package tests;

import java.util.Base64;
import java.util.Random;
import java.util.Scanner;

public class pruebas {

  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("kei");
    String key=s.nextLine();
    System.out.println("msg");
    String a=s.nextLine();
    byte[] b=a.getBytes();
    byte k=0;
    for (int i = 0; i < key.getBytes().length; i++) {
      k+=key.getBytes()[i];
      
    }

       
    for (int i =  0; i <b.length; i++) {
      b[i]=(byte) (b[i]+k);
      System.out.print(String.valueOf(b[i])+" - ");
    }


    System.out.println("\n"+a);
    System.out.println(   new String(b));
    
    for (int i =  0; i <b.length; i++) {
      b[i]=(byte) (b[i]-k);
  
    }
    System.out.println(   new String(b));
}
}