package G;

/*
* 有键盘输出字符串,可以有删除键.完整记录键盘的按键顺序.给定两个输出的字符串,
* 问两个输入串在屏幕最终显示是不是一样?
* 比如,"abcc删除fg","abcaa删除删除fg",这两个就是一样的.要求常量空间.面试官给了一个提示才做出来...
*
* */
public class CompareStrings {
    public boolean compareStrings(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        int countA = 0;
        int countB = 0;
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == '#' || b.charAt(j) == '#') {
                if (a.charAt(i) == '#') {
                    i--;
                    countA++;
                }

                if (b.charAt(j) == '#') {
                    j--;
                    countB++;
                }
            } else {
                if (countA == 0 && countB == 0) {
                    if (a.charAt(i) != b.charAt(j)) {
                        return false;
                    } else {
                        i--;
                        j--;
                    }
                } else {
                    if (countA > 0) {
                        countA--;
                        i--;
                    }

                    if (countB > 0) {
                        countB--;
                        j--;
                    }
                }

            }
        }

        while (i >= 0) {
            if (a.charAt(i) == '#') {
                countA++;
                i--;
            } else {
                if (countA == 0) {
                    return false;
                }
                i--;
            }
        }

        while (j >= 0) {
            if (b.charAt(j) == '#') {
                countB++;
                j--;
            } else {
                if (countB == 0) {
                    return false;
                }
                j--;
            }
        }
        return true;
    }













}
