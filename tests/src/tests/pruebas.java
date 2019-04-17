package tests;

import java.util.Base64;
import java.util.Random;
import java.util.Scanner;

public class pruebas {

  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    
    System.out.println("Escribe msg");
    String m=s.nextLine();
    System.out.println(" Escribe kei1");
    String key=s.nextLine();
    System.out.println(" Escribe kei2 ");
    String key2=s.nextLine();

    byte k=obtener_clave(key);
k+=obtener_clave(key2);

String cifrao=cif(m,  key, k);


    System.out.println("\n\nEncriptado");
    System.out.println(new String(cifrao));
    
    
    while(1==1) {
    System.out.println("clave descifrar1");
    key=s.nextLine();
    k=obtener_clave(key);
    System.out.println("clave descifrar2");
    key2=s.nextLine();
    k+=obtener_clave(key2);
    String cescifrao=desc(cifrao.getBytes(), k);
    System.out.println(  "\nDescifrao \n"+cescifrao);
}
  }
  
  
  public static String cif(String m,String key,byte k) {
    
    byte[] b=m.getBytes();
    System.out.println("\n\n bytes");
 for (int i =  0; i <b.length; i++) {
   b[i]=(byte) (b[i]+k);
   System.out.print(String.valueOf(b[i])+" - ");
 }
      return new String(b);
    
  }
  
  public static String desc(byte[]b,byte k) {
    
    for (int i =  0; i <b.length; i++) {
      b[i]=(byte) (b[i]-k);
  
    }
    return new String(b);
  }
  public static byte obtener_clave(String key) {
    byte k=0;
    for (int i = 0; i < key.getBytes().length; i++) {
      k+=key.getBytes()[i];
      
    }
    
    return k;
  }
  
}