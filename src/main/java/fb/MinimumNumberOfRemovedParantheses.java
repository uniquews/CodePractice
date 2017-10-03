package fb;

/**
 * 题目是Sting包括（）和字母，求删除最少的括号个数使得括号成对，其中字母不影响。case 1 ：((a)  1，  case 2: ((a)(b)) 0
 * */
public class MinimumNumberOfRemovedParantheses {
    public int minRemove(String s) {
        int count = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                continue;
            }
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                result++;
                count = 0;
            }
        }
        return result + count;
    }

    public static void main(String[] args) {
        String s = ")((()";
        MinimumNumberOfRemovedParantheses test = new MinimumNumberOfRemovedParantheses();
        System.out.println(test.minRemove(s));
    }
}
