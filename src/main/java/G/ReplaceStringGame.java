package G;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 两个人做替换字符串的游戏，比如给"aabaaaa", 替换规则是 ba->aaa, b->aa,
 * 当没有可以替换的字符时当前玩家输，怎么判断游戏结束？如果规则有很多怎么办？如何判断哪个人赢？
 * */

public class ReplaceStringGame {
    Map<String, Boolean> cache = new HashMap<>();
    public boolean replaceStringGame(String a, List<String[]> rules) {

        if (cache.containsKey(a)) {
            return cache.get(a);
        }

        for (String[] rule : rules) {
            String origin = rule[0];
            String target = rule[1];

            int index = 0;
            while (a.indexOf(origin, index) != -1) {
                StringBuilder sb = new StringBuilder();
                int pos = a.indexOf(origin);
                sb.append(a.substring(0, pos));
                sb.append(target);
                sb.append(a.substring(pos + origin.length()));

                if (!replaceStringGame(sb.toString(), rules)) {
                    cache.put(a, true);
                    return true;
                }
                index++;
            }

        }
        cache.put(a, false);
        return false;
    }
}
