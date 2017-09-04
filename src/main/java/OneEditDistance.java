/**
 * Created by shuaiwang on 5/14/17.
 */
public class OneEditDistance {
//    public boolean isOneEditDistance(String s, String t) {
//        if (s.length() == t.length()) {
//            for (int i = 0; i < s.length(); i++) {
//                if (s.charAt(i) != t.charAt(i)) {
//                    return i == s.length() - 1 || s.substring(i + 1).equals(t.substring(i + 1));
//                }
//            }
//        } else if (s.length() == t.length() + 1) {
//            for (int i = 0; i < t.length(); i++) {
//                if (s.charAt(i) != t.charAt(i)) {
//                    return s.substring(i + 1).equals(t.substring(i));
//                }
//            }
//            return true;
//        } else if (t.length() == s.length() + 1) {
//            for (int i = 0; i < s.length(); i++) {
//                if (s.charAt(i) != t.charAt(i)) {
//                    return t.substring(i + 1).equals(s.substring(i));
//                }
//            }
//            return true;
//        }
//        return false;
//    }
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() == t.length()) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == t.charAt(i)) {
                    continue;
                }
                return s.substring(i + 1).equals(t.substring(i + 1));
            }
        }

        if (s.length() == t.length() + 1) {
            int i = 0;
            for (; i < t.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    break;
                }
            }
            return t.substring(i).equals(s.substring(i + 1));
        }

        if (s.length() + 1 == t.length()) {
            int i = 0;
            for (; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    break;
                }
            }
            return s.substring(i).equals(t.substring(i + 1));
        }
        return false;
    }

    public static void main(String[] args) {
        OneEditDistance test = new OneEditDistance();
        test.isOneEditDistance("a", "ac");
    }
}

