import java.util.*;

public class HashSet1 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Agra");
        set.add("Mathura");
        set.add("Noida");
        set.add("Delhi");

        // Iterator<String> it = set.iterator();
        // while (it.hasNext()) {
        //     System.out.println(it.next());
        // }
        System.out.println(set);

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Agra");
        lhs.add("Mathura");
        lhs.add("Noida");
        lhs.add("Delhi");

        System.out.println(lhs);

        TreeSet<String> ts = new TreeSet<>();
        ts.add("Agra");
        ts.add("Mathura");
        ts.add("Noida");
        ts.add("Delhi");
        System.out.println(ts);
    }
}
