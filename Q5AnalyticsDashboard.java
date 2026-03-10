import java.util.*;

public class Q5AnalyticsDashboard {

    HashMap<String, Integer> pageViews = new HashMap<>();
    HashMap<String, Set<String>> uniqueVisitors = new HashMap<>();
    HashMap<String, Integer> sourceCount = new HashMap<>();

    public void process(String url, String user, String source) {

        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);

        uniqueVisitors.putIfAbsent(url, new HashSet<>());
        uniqueVisitors.get(url).add(user);

        sourceCount.put(source, sourceCount.getOrDefault(source, 0) + 1);
    }

    public static void main(String[] args) {

        Q5AnalyticsDashboard a = new Q5AnalyticsDashboard();

        a.process("/news", "u1", "google");
        a.process("/news", "u2", "facebook");

        System.out.println(a.pageViews);
    }
}