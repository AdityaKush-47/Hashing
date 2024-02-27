import java.util.*;
public class HashMap1 {
    public static void main(String[] args) {
      HashMap<String , Integer> hm = new HashMap<>();

      hm.put("India", 140);
      hm.put("China", 145);
      hm.put("US", 33);

      System.out.println(hm);

      int pop = hm.get("India");
      System.out.println(pop);
      System.out.println(hm.get("Nepal"));
      System.out.println(hm.containsKey("India"));
      hm.remove("US");
      System.out.println(hm);
      hm.clear();
      System.out.println(hm);

    }
}
