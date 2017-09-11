import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaiwang on 5/21/17.
 */
public class TextJustification {
//    public List<String> fullJustify(String[] words, int maxWidth) {
//        List<String> eachLine = new ArrayList<>();
//        List<String> result = new ArrayList<>();
//        int len = 0;
//        for (int i = 0; i < words.length; i++) {
//            String s = words[i];
//            if (len + s.length() + eachLine.size() <= maxWidth) {
//                eachLine.add(s);
//                len += s.length();
//            } else {
//                // call helper
//                getEachLine(eachLine, result, maxWidth, len);
//                len = 0;
//                i--;
//                eachLine.clear();
//            }
//        }
//        getLastLine(eachLine, result, maxWidth);
//        return result;
//    }
//
//    private void getEachLine(List<String> eachLine, List<String> result, int maxWidth, int len) {
//        int count = eachLine.size();
//        StringBuilder sb = new StringBuilder();
//        int totalSpace = maxWidth - len;
//
//        for (String s : eachLine) {
//            sb.append(s);
//            int gap;
//            if (count == 1) {
//                gap = totalSpace;
//            } else {
//                gap = (totalSpace % (count - 1)) == 0 ? (totalSpace / (count - 1)) : (totalSpace / (count - 1)) + 1;
//            }
//            char[] spaces;
//            if (totalSpace >= gap) {
//                spaces = new char[gap];
//                totalSpace -= gap;
//            } else {
//                spaces = new char[totalSpace];
//                totalSpace -= totalSpace;
//            }
//            Arrays.fill(spaces, ' ');
//            sb.append(new String(spaces));
//            count--;
//        }
//        result.add(sb.toString());
//    }
//
//    private void getLastLine(List<String> eachLine, List<String> result, int maxWidth) {
//        StringBuilder sb = new StringBuilder();
//        for (String s : eachLine) {
//            sb.append(s);
//            if (sb.length() < maxWidth)
//                sb.append(" ");
//        }
//        while (maxWidth - sb.length() > 0) {
//            sb.append(" ");
//        }
//        result.add(sb.toString());
//    }
public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    List<String> eachResult = new ArrayList<>();
    int len = 0;
    for (int i = 0; i < words.length; i++) {
        if (len + words[i].length() + eachResult.size() <= maxWidth) {
            len += words[i].length();
            eachResult.add(words[i]);
        } else {
            getEachLine(eachResult, result, maxWidth, len);
            len = 0;
            eachResult.clear();
            i--;
        }
    }
    getLastLine(eachResult, result, len, maxWidth);
    return result;
}

    private void getEachLine(List<String> eachResult, List<String> result, int maxWidth, int len) {
        int count = eachResult.size();
        StringBuilder sb = new StringBuilder();
        if (count == 1) {
            sb.append(eachResult.get(0));
            appendSpace(sb, maxWidth - len);
            result.add(sb.toString());
            return;
        }

        int remain = maxWidth - len;
        sb.append(eachResult.get(0));
        for (int i = 1; i < eachResult.size(); i++) {
            int space = (int)Math.ceil(remain / ((count - 1) * 1.0));
            appendSpace(sb, space);
            sb.append(eachResult.get(i));
            remain -= space;
            count--;
        }
        result.add(sb.toString());
    }

    private void appendSpace(StringBuilder sb, int space) {
        while (space > 0) {
            sb.append(" ");
            space--;
        }
    }

    private void getLastLine(List<String> eachResult, List<String> result, int len, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        sb.append(eachResult.get(0));
        for (int i = 1; i < eachResult.size(); i++) {
            sb.append(" ");
            sb.append(eachResult.get(i));
        }

        if (len + eachResult.size() - 1 < maxWidth) {
            appendSpace(sb, maxWidth - (len + eachResult.size() - 1));
        }
        result.add(sb.toString());
    }

}
