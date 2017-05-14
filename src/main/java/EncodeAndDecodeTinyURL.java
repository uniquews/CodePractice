import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 5/6/17.
 */
public class EncodeAndDecodeTinyURL {

    // 简单的方法，用十进制
    List<String> urls = new ArrayList<String>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urls.add(longUrl);
        return String.valueOf(urls.size()-1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.valueOf(shortUrl);
        return (index<urls.size())?urls.get(index):"";
    }

    // 复杂的方法，把key -> longUrl 的key变成62进制的一个数，每次的
    // 62^6应该是一个很大的数，然后每一步的char就是tinyurl的char

//    private Map<Integer, String> map;
//    private int pk;
//    private static final String TINY_URL_DOMAIN = "http://tiny.url/";
//
//    public TinyUrl() {
//        this.map = new HashMap<>();
//        pk = 0;
//    }
//
//    /**
//     * @param url a long url
//     * @return a short url starts with http://tiny.url/
//     */
//    public String longToShort(String url) {
//        // Write your code here
//        pk++;
//        map.put(pk, url);
//        return TINY_URL_DOMAIN + base62();
//    }
//
//    private String base62() {
//        char[] chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
//        StringBuilder sb = new StringBuilder();
//        int tmp = this.pk; // 62^6
//        for (int i = 0; i < 6; i++) {
//            sb.insert(0, chars[tmp % 62]);
//            tmp = tmp / 62;
//        }
//        return sb.toString();
//    }
//
//    private int rebase62(String tinyUrl) {
//        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        int primaryKey = 0;
//        int x = 1;
//        for (int i = tinyUrl.length() - 1; i >= 0; i--) {
//            char c = tinyUrl.charAt(i);
//            primaryKey += chars.indexOf(c) * x;
//            x *= 62;
//        }
//        return primaryKey;
//    }
//、
//    /**
//     * @param url a short url starts with http://tiny.url/
//     * @return a long url
//     */
//    public String shortToLong(String url) {
//        // Write your code here
//        String tinyUrl = url.substring(url.length() - 6);
//        return map.get(rebase62(tinyUrl));
//    }
}
