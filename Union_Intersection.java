import java.util.ArrayList;
import java.util.HashSet;

public class Union_Intersection {
    static void union(int arr1[],int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        System.out.println(set);
    }
    static void intersection(int arr1[],int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if(set.contains(arr2[i])) {
                ans.add(arr2[i]);
                set.remove(arr2[i]);
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)+" ");
        }
    }
    public static void main(String[] args) {
        int arr1[] = {7,3,9,8};
        int arr2[] = {6,3,9,2,9,4,8};
        union(arr1,arr2);
        intersection(arr1, arr2);
    }
}
