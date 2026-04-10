import java.util.*;

class Client {
    String name;
    int riskScore;

    Client(String name, int riskScore) {
        this.name = name;
        this.riskScore = riskScore;
    }

    public String toString() {
        return name + ":" + riskScore;
    }
}

public class Q2ClientRiskRanking {

    // Bubble Sort (ascending)
    static void bubbleSort(Client[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("Bubble (asc): " + Arrays.toString(arr));
    }

    // Insertion Sort (descending)
    static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].riskScore < key.riskScore) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("Insertion (desc): " + Arrays.toString(arr));
    }

    // Top risks
    static void topRisks(Client[] arr) {
        System.out.print("Top Risks: ");
        for (int i = 0; i < Math.min(10, arr.length); i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Client[] arr = {
            new Client("A", 20),
            new Client("B", 50),
            new Client("C", 80)
        };

        bubbleSort(arr);
        insertionSort(arr);
        topRisks(arr);
    }
}