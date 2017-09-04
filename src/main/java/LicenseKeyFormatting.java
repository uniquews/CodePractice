/**
 * Created by shuaiwang on 2/22/17.
 */
public class LicenseKeyFormatting {
//    public String licenseKeyFormatting(String S, int k) {
//        if (S == null || S.length() == 0) {
//            return "";
//        }
//        String A = S.replaceAll("-", "");
//
//        if (A.length() == 0) {
//            return "";
//        }
//        StringBuilder sb = new StringBuilder();
//        int i = A.length() - 1;
//
//        while (i >= 0) {
//            int j = i;
//            while (i - j + 1 < k && j > 0) {
//                j--;
//            }
//            String current = A.substring(j, i + 1).toUpperCase();
//            sb.insert(0, current);
//            sb.insert(0, "-");
//            i = j - 1;
//        }
//        sb.deleteCharAt(0);
//        return sb.toString();
//    }

    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.length() == 0)
            return S;

        S = S.replaceAll("-", "");

        StringBuilder sb = new StringBuilder();

        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '-')
                continue;
            int j = i;
            int times = K;
            while (j >= 0 && times > 0) {
                sb.insert(0, Character.toUpperCase(S.charAt(j)));
                times--;
                j--;
            }
            sb.insert(0, '-');
            i = j + 1;
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }

    public static void main(String[] args) {
        /**
         *
         * "--a-a-a-a--"
            2
         */
        LicenseKeyFormatting test = new LicenseKeyFormatting();
        String input = "--a-a-a-a--";
        System.out.print(test.licenseKeyFormatting(input, 2));
    }
}
