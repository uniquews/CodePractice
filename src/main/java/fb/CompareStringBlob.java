package fb;

public class CompareStringBlob {
    public int compareStringBlob(String s, String t) {
        if (s == null && t == null) {
            return 0;
        }

        if (s == null || t == null) {
            return s == null ? -1 : 1;
        }

        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (Character.isDigit(s.charAt(i)) && Character.isDigit(t.charAt(j))) {
                int m = i;
                int n = j;
                while (m < s.length() && Character.isDigit(s.charAt(m))) {
                    m++;
                }

                while (n < t.length() && Character.isDigit(t.charAt(n))) {
                    n++;
                }

                String tmp1 = s.substring(i, m);
                String tmp2 = t.substring(j, n);

                if (tmp1.length() < tmp2.length()) {
                    return -1;
                } else if (tmp1.length() > tmp2.length()) {
                    return 1;
                }

                if (tmp1.compareTo(tmp2) != 0) {
                    return tmp1.compareTo(tmp2) < 0 ? -1 : 1;
                }

                i = m;
                j = n;
            } else if (Character.isLetter(s.charAt(i)) && Character.isLetter(s.charAt(i))) {
                int m = i;
                int n = j;
                while (m < s.length() && Character.isLetter(s.charAt(m))) {
                    m++;
                }

                while (n < t.length() && Character.isLetter(t.charAt(n))) {
                    n++;
                }
                String tmp1 = s.substring(i, m);
                String tmp2 = t.substring(j, m);

                if (tmp1.compareTo(tmp2) != 0) {
                    return tmp1.compareTo(tmp2) < 0 ? -1 : 1;
                }
                i = m;
                j = n;
            } else {
                return Character.isLetter(s.charAt(i)) ? -1 : 1;
            }
        }

        if (i < s.length()) {
            return 1;
        }

        if (j < t.length()) {
            return -1;
        }

        return 0;
    }

    public static void main(String[] args) {
        String a = "a12b";
        String b = "a124";

        CompareStringBlob test = new CompareStringBlob();
        System.out.println(test.compareStringBlob(a, b));
    }
}
