import java.util.*;

class DNSEntry {
    String ip;
    long expiryTime;

    DNSEntry(String ip, int ttl) {
        this.ip = ip;
        this.expiryTime = System.currentTimeMillis() + ttl * 1000;
    }

    boolean isExpired() {
        return System.currentTimeMillis() > expiryTime;
    }
}

public class DNSCache {

    private HashMap<String, DNSEntry> cache = new HashMap<>();

    public String resolve(String domain) {

        DNSEntry entry = cache.get(domain);

        if (entry != null && !entry.isExpired()) {
            return "Cache HIT: " + entry.ip;
        }

        String ip = queryDNS(domain);
        cache.put(domain, new DNSEntry(ip, 300));

        return "Cache MISS -> " + ip;
    }

    private String queryDNS(String domain) {
        return "192.168.1." + new Random().nextInt(255);
    }

    public static void main(String[] args) {

        DNSCache dns = new DNSCache();

        System.out.println(dns.resolve("google.com"));
        System.out.println(dns.resolve("google.com"));
    }
}