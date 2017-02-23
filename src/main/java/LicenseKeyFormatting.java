/**
 * Created by shuaiwang on 2/22/17.
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int k) {
        if (S == null || S.length() == 0) {
            return "";
        }
        String A = S.replaceAll("-", "");

        if (A.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = A.length() - 1;

        while (i >= 0) {
            int j = i;
            while (i - j + 1 < k && j > 0) {
                j--;
            }
            String current = A.substring(j, i + 1).toUpperCase();
            sb.insert(0, current);
            sb.insert(0, "-");
            i = j - 1;
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }

    public static void main(String[] args) {
        LicenseKeyFormatting test = new LicenseKeyFormatting();
        String input = "2-4A0r7-4k";
        System.out.print(test.licenseKeyFormatting(input, 3));
    }
}
