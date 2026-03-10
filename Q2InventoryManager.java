import java.util.*;

public class InventoryManager {

    private HashMap<String, Integer> stock = new HashMap<>();
    private HashMap<String, Queue<Integer>> waitingList = new HashMap<>();

    public void addProduct(String productId, int quantity) {
        stock.put(productId, quantity);
        waitingList.put(productId, new LinkedList<>());
    }

    public synchronized String purchaseItem(String productId, int userId) {

        int currentStock = stock.getOrDefault(productId, 0);

        if (currentStock > 0) {
            stock.put(productId, currentStock - 1);
            return "Purchase Success. Remaining: " + (currentStock - 1);
        } else {
            waitingList.get(productId).add(userId);
            return "Added to waiting list position: " + waitingList.get(productId).size();
        }
    }

    public int checkStock(String productId) {
        return stock.getOrDefault(productId, 0);
    }

    public static void main(String[] args) {

        InventoryManager im = new InventoryManager();

        im.addProduct("IPHONE15", 2);

        System.out.println(im.purchaseItem("IPHONE15", 101));
        System.out.println(im.purchaseItem("IPHONE15", 102));
        System.out.println(im.purchaseItem("IPHONE15", 103));
    }
}