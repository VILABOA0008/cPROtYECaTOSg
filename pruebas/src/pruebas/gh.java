package pruebas;

import java.util.HashSet;
import java.util.Set;

public class gh {

  public static void main(String[] args) {
    Set<Integer> s=new HashSet<>();
    
    s.add(2);
    System.out.println(s.size());
    s.add(3);
    System.out.println(s.size());
    s.add(6);
    s.forEach(n->System.out.println(n));

  }

}
