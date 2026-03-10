import java.util.*;

public class Q6RateLimiter {

    HashMap<String, Integer> requests = new HashMap<>();
    int LIMIT = 5;

    public boolean allow(String client) {

        int used = requests.getOrDefault(client, 0);

        if (used >= LIMIT) return false;

        requests.put(client, used + 1);

        return true;
    }

    public static void main(String[] args) {

        Q6RateLimiter rl = new Q6RateLimiter();

        for (int i = 0; i < 7; i++)
            System.out.println(rl.allow("client1"));
    }
}