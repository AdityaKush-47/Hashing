import java.util.HashMap;

public class Largest_Subarray_With_Zero_Sum {
    public static void main(String[] args) {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 3 };
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                length = Math.max(length, (i - map.get(sum)));
            } else {
                map.put(sum, i);
            }
        }
        System.out.println("Largest length of subarray with sum 0 is : " + length);
    }
}
