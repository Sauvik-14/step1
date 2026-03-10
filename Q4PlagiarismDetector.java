import java.util.*;

public class Q4PlagiarismDetector {

    HashMap<String, Set<String>> map = new HashMap<>();

    public void addDocument(String docId, String text) {

        String[] words = text.split(" ");

        for (int i = 0; i < words.length - 4; i++) {

            String gram = String.join(" ", Arrays.copyOfRange(words, i, i + 5));

            map.putIfAbsent(gram, new HashSet<>());
            map.get(gram).add(docId);
        }
    }

    public int check(String text) {

        String[] words = text.split(" ");
        int matches = 0;

        for (int i = 0; i < words.length - 4; i++) {

            String gram = String.join(" ", Arrays.copyOfRange(words, i, i + 5));

            if (map.containsKey(gram)) matches++;
        }

        return matches;
    }

    public static void main(String[] args) {

        Q4PlagiarismDetector pd = new Q4PlagiarismDetector();

        pd.addDocument("doc1", "machine learning is very powerful technology");

        System.out.println(pd.check("machine learning is very powerful"));
    }
}