import java.util.*;

public class Q9TwoSumTransactions {

    public static void findPair(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {

            int comp = target - num;

            if (map.containsKey(comp)) {
                System.out.println("Pair: " + num + " + " + comp);
            }

            map.put(num, 1);
        }
    }

    public static void main(String[] args) {

        int[] arr = {500, 300, 200};

        findPair(arr, 500);
    }
}
