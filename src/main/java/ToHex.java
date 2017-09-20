public class ToHex {

    /**
     *
     * 题目： http://www.jiuzhang.com/article/Facebook%20%E9%9D%A2%E8%AF%95%E9%A2%98%20%7C%20%E5%B0%86%E6%95%B0%E5%AD%97%E8%BD%AC%E6%8D%A2%E4%B8%BA%E5%8D%81%E5%85%AD%E8%BF%9B%E5%88%B6/
     * 每一个数在计算机中表示成二进制就已经handle了
     * 按照二进制，每4位可以表示成十六进制的一位
     * 这个方法只适合2的整数次方的进制
     * */
    public String toHex(int num) {
        String digit = "0123456789abcdef";
        String s = "";
        int count = 0;
        while (num != 0 && count < 8) {
            int tmp = num & 15; // 15 = 1111
            s = digit.charAt(tmp) + s;
            num = num >> 4;
            count++;
        }
        return s;
    }

    public static void main(String[] args) {
        int a = -1;
        ToHex test = new ToHex();
        System.out.println(test.toHex(a));
    }
}
