import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 3/1/17.
 */
public class EncodeAndDecodeStrings {

    // Encodes a list of strings to a single string.
//    public String encode(List<String> strs) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < strs.size(); i++) {
//            sb.append(strs.get(i).length()).append("/").append(strs.get(i));
//        }
//        return sb.toString();
//    }
//
//    // Decodes a single string to a list of strings.
//    public List<String> decode(String s) {
//        List<String> li = new ArrayList<>();
//
//        int i = 0;
//        while (i < s.length()) {
//            int slash = s.indexOf("/", i);
//            int size = Integer.parseInt(s.substring(i, slash));
//            li.add(s.substring(slash + 1, slash + 1 + size));
//            i = slash + size + 1;
//        }
//        return li;
//    }

//    public String encode(List<String> strs) {
//        StringBuilder sb = new StringBuilder();
//        for (String s : strs) {
//            int size = s.length();
//            sb.append(size).append("@").append(s);
//        }
//        return sb.toString();
//    }
//
//    // Decodes a single string to a list of strings.
//    public List<String> decode(String s) {
//        List<String> result = new ArrayList<>();
//
//        int i = 0;
//        while (i < s.length()) {
//            int at = s.indexOf("@", i);
//            int size = Integer.valueOf(s.substring(i, at));
//            String cur = s.substring(at + 1, at + 1 + size);
//            result.add(cur);
//            i = at + 1 + size;
//        }
//        return result;
//    }
//    public String encode(List<String> strs) {
//        StringBuilder sb = new StringBuilder();
//        for (String s : strs) {
//            int len = s.length();
//            sb.append(len).append("@").append(s);
//        }
//        return sb.toString();
//    }
//
//    // Decodes a single string to a list of strings.
//    public List<String> decode(String s) {
//        int i = 0;
//        List<String> result = new ArrayList<>();
//        while (i < s.length()) {
//            int at = s.indexOf("@", i);
//            int size = Integer.valueOf(s.substring(i, at));
//            String str = s.substring(at + 1, at + 1 + size);
//            result.add(str);
//            i = at + 1 + size;
//        }
//        return result;
//    }

    List<String> list = new ArrayList<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int index = list.size();
        list.add(longUrl);
        return base64(index);
    }

    private String base64(int n) {
        char[] chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ*#".toCharArray();
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int index = n % 64;
            sb.append(chars[index]);
            n /= 64;
        }
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return list.get(reBase64(shortUrl));
    }

    private int reBase64(String s) {
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ*#";
        int base = 1;
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int index = chars.indexOf(s.charAt(i));
            ans += index * base;
            base *= 64;
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
