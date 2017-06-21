/**
 * Created by shuaiwang on 6/18/17.
 */
public class ReverseWordsinaString {
//    public String reverseWords(String s) {
//        if (s == null || s.length() == 0)
//            return s;
//        int index = s.length() - 1;
//
//        StringBuilder sb = new StringBuilder();
//        while (index >= 0) {
//            while (index >= 0 && s.charAt(index) == ' ') {
//                index--;
//            }
//
//            if (index < 0) {
//                break;
//            }
//
//            int start = index;
//            while (start >= 0 && s.charAt(start) != ' ') {
//                start--;
//            }
//            sb.append(s.substring(start + 1, index + 1)).append(" ");
//            index = start;
//        }
//
//        return sb.deleteCharAt(sb.length() - 1).toString();
//    }


    /**
     * Java split 函数的用法
     *
     * 1. 当有两个连续的分隔符出现的时候，除了第一个分隔符之外，其余都会变成""
     *
     * 2. split 有一个take 两个arguments的 function  有一个limit 变量控制想要分割成的数组的大小
     *
     * 3  最基本的split数组就是当limit = 0的时候，此时会trim掉结尾所有的""
     *
     * */
    public String reverseWords(String s) {
        // write your code
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == "") {
                sb.append(array[i]).append(" ");
            }
        }

        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1).toString();
    }

    public static void main(String[] args) {
        String a = "booof";
        String[] tmp = a.split("o");
        for (int i = 0; i < tmp.length; i++) {
            System.out.println(tmp[i]);
        }

    }
}
