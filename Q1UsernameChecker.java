import java.util.*;

public class UsernameChecker {

    private HashMap<String, Integer> usernames = new HashMap<>();
    private HashMap<String, Integer> attempts = new HashMap<>();

    public boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !usernames.containsKey(username);
    }

    public void registerUser(String username, int userId) {
        usernames.put(username, userId);
    }

    public List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            suggestions.add(username + i);
        }
        suggestions.add(username.replace("_", "."));
        return suggestions;
    }

    public String getMostAttempted() {
        return Collections.max(attempts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        UsernameChecker uc = new UsernameChecker();

        uc.registerUser("john_doe", 1);

        System.out.println(uc.checkAvailability("john_doe"));
        System.out.println(uc.suggestAlternatives("john_doe"));
    }
}