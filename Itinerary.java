import java.util.HashMap;

public class Itinerary {

    public static String getStart(HashMap<String,String> ticket) {
        HashMap<String,String> revMap = new HashMap<>();
        for (String key : ticket.keySet()) {
            revMap.put(ticket.get(key),key);
        }
        for(String key : ticket.keySet()) {
            if(!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<String,String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        System.out.print(start);
        for(String key : tickets.keySet()) {
            System.out.print("->" + tickets.get(start));
            start = tickets.get(start);
        }
    }
}
