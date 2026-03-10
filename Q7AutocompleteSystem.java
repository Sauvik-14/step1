import java.util.*;

public class Q7AutocompleteSystem {

    HashMap<String, Integer> queries = new HashMap<>();

    public void addQuery(String q) {
        queries.put(q, queries.getOrDefault(q, 0) + 1);
    }

    public void search(String prefix) {

        for (String q : queries.keySet()) {
            if (q.startsWith(prefix)) {
                System.out.println(q);
            }
        }
    }

    public static void main(String[] args) {

        Q7AutocompleteSystem ac = new Q7AutocompleteSystem();

        ac.addQuery("java tutorial");
        ac.addQuery("javascript");

        ac.search("jav");
    }
}