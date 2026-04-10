import java.util.*;

public class Q6RiskThresholdSearch {

    // Linear Search
    static void linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Found at: " + i);
                return;
            }
        }
        System.out.println("Not Found");
    }

    // Binary Floor & Ceiling
    static void binaryFloorCeil(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int floor = -1, ceil = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                floor = ceil = arr[mid];
                break;
            } else if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceil = arr[mid];
                high = mid - 1;
            }
        }

        System.out.println("Floor: " + floor + ", Ceiling: " + ceil);
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 50, 100};

        linearSearch(arr, 30);
        binaryFloorCeil(arr, 30);
    }
}