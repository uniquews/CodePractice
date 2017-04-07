import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuaiwang on 4/6/17.
 */
public class FractionTtoRecurringDecimal {
    public String fractionToDecimal(int num, int den) {
        if (num == 0) {
            return "0";
        }
        boolean sign = true;
        if (num < 0 && den > 0 || num > 0 && den < 0) {
            sign = false;
        }
        long numerator = Math.abs((long)num);
        long denominator = Math.abs((long)den);

        StringBuilder sb = new StringBuilder();
        long remain = numerator;
        if (numerator < denominator) {
            sb.append("0.");
            remain *= 10;
        } else {
            sb.append(numerator / denominator);
            remain = numerator % denominator * 10;
            if (remain != 0) {
                sb.append(".");
            }
        }

        int dupStart = -1;
        HashMap<Long, Integer> hashMap = new HashMap<>();

        while (remain != 0) {
            long lastN = remain;
            if (hashMap.containsKey(remain)) {
                dupStart = hashMap.get(remain);
                break;
            }
            sb.append(remain / denominator);
            remain = remain % denominator * 10;
            if (!hashMap.containsKey(lastN))
                hashMap.put(lastN, sb.length() - 1);
        }

        if (remain != 0) {
            sb.insert(dupStart, "(");
            sb.append(")");
        }

        if (!sign) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FractionTtoRecurringDecimal test = new FractionTtoRecurringDecimal();
//        int n = 1;
//        int d = 6;
//        int n = 20;
//        int d = 4;
//        int n = 4;
//        int d = 20;
//        int n = 2;
//        int d = 33;
//        int n = 7;
//        int d = -12;

        int n = -1;
        int d = -2147483648;
        System.out.println(test.fractionToDecimal(n, d));
    }
}
