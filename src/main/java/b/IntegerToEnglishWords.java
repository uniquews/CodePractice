package b;

/**
 * Created by bohan on 5/13/17.
 */
public class IntegerToEnglishWords {
    private static final String[] MORE_THAN_THOUSANDS = {"", "Thousand", "Million", "Billion"};
    private static final String[] LESS_THAN_HUNDRED = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety"};
    private static final String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        int n = 0;
        while (num != 0) {
            String str = helper(num % 1000);
            num = num / 1000;
            if (str.length() > 0) {
                sb.insert(0, " ").insert(0, MORE_THAN_THOUSANDS[n]).insert(0, " ");
            }
            sb.insert(0, str);
            n++;
        }
        return sb.toString().trim();
    }

    private String helper(int num) {
        StringBuilder sb = new StringBuilder();
        // num < 1000.
        int hundred = num / 100;
        if (hundred > 0) {
            sb.append(LESS_THAN_TWENTY[hundred]).append(" Hundred ");
        }
        int ten = num % 100;
        if (ten < 20) {
            sb.append(LESS_THAN_TWENTY[ten]);
            return sb.toString().trim();
        }
        return sb
                .append(LESS_THAN_HUNDRED[(ten / 10) - 2])
                .append(" ")
                .append(LESS_THAN_TWENTY[ten % 10])
                .toString()
                .trim();
    }
}
