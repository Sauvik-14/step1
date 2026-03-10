import java.util.*;

public class Q10MultiLevelCache {

    HashMap<String, String> L1 = new HashMap<>();
    HashMap<String, String> L2 = new HashMap<>();

    public String getVideo(String id) {

        if (L1.containsKey(id))
            return "L1 HIT";

        if (L2.containsKey(id)) {
            L1.put(id, L2.get(id));
            return "L2 HIT";
        }

        L2.put(id, "VideoData");

        return "Database HIT";
    }

    public static void main(String[] args) {

        Q10MultiLevelCache c = new Q10MultiLevelCache();

        System.out.println(c.getVideo("v1"));
        System.out.println(c.getVideo("v1"));
    }
}