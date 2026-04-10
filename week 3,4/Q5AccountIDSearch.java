import java.util.*;

public class Q5AccountIDSearch {

    // Linear Search
    static void linearSearch(String[] arr, String target) {
        int first = -1, last = -1, count = 0;

        for (int i = 0; i < arr.length; i++) {
            count++;
            if (arr[i].equals(target)) {
                if (first == -1) first = i;
                last = i;
            }
        }

        System.out.println("Linear First: " + first + ", Last: " + last);
        System.out.println("Comparisons: " + count);
    }

    // Binary Search
    static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1, count = 0;

        while (low <= high) {
            count++;
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                System.out.println("Binary Found at: " + mid);
                System.out.println("Comparisons: " + count);
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else high = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] arr = {"accA", "accB", "accB", "accC"};
        Arrays.sort(arr);

        linearSearch(arr, "accB");
        binarySearch(arr, "accB");
    }
}