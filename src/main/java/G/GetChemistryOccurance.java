package G;

import java.util.*;

public class GetChemistryOccurance {
    public Map<String, Integer> getChemistryOccurance(String s) {
        return dfs(s,  1);
    }
    public Map<String, Integer> dfs(String s, int count) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                int j = i + 1;
                String chem;
                if (j < s.length() && (Character.isLowerCase(s.charAt(j)))) {
                    j++;
                    chem = s.substring(i, j);
                } else {
                    chem = s.substring(i, j);
                }

                if (j < s.length() && Character.isDigit(s.charAt(j))) {
                    int k = j;
                    while (j < s.length() && Character.isDigit(s.charAt(j))) {
                        j++;
                    }
                    map.put(chem, map.getOrDefault(chem, 0) + Integer.valueOf(s.substring(k, j)));
                } else {
                    map.put(chem, map.getOrDefault(chem, 0) + 1);
                }
                i = j - 1;
            } else if (s.charAt(i) == '(') {
                int right = helper(s, i);
                Map<String, Integer> next;
                if (right + 1 < s.length() && Character.isDigit(s.charAt(right + 1))) {
                    int j = right + 1;
                    while (j < s.length() && Character.isDigit(s.charAt(j))) {
                        j++;
                    }
                    int num = Integer.valueOf(s.substring(right + 1, j));
                    next = dfs(s.substring(i + 1, right), num);
                    i = j - 1;
                } else {
                    next = dfs(s.substring(i + 1, right), 1);
                    i = right;
                }

                for (String c : next.keySet()) {
                    map.put(c, map.getOrDefault(c, 0) + next.get(c));
                }
            }
        }

        for (String c : map.keySet()) {
            map.put(c, map.get(c) * count);
        }
        return map;
    }

    private int helper(String s, int left) {
        int count = 1;
        for (int i = left + 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            } else {
                continue;
            }

            if (count == 0) {
                return i;
            }
        }
        return -1; // dummy
    }

    public Map<String, Integer> iterativeWay(String s) {
        Stack<Map<String, Integer>> stk = new Stack<>();
        stk.push(new HashMap<>());

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                int j = i + 1;
                String chem;
                if (j < s.length() && Character.isLowerCase(s.charAt(j))) {
                    j++;
                    chem = s.substring(i, j);
                } else {
                    chem = s.substring(i, j);
                }

                int k = j;
                if (j < s.length() && Character.isDigit(s.charAt(j))) {
                    while (j < s.length() && Character.isDigit(s.charAt(j))) {
                        j++;
                    }
                    int num = Integer.valueOf(s.substring(k, j));
                    stk.peek().put(chem, stk.peek().getOrDefault(chem, 0) + num);
                } else {
                    stk.peek().put(chem, stk.peek().getOrDefault(chem, 0) + 1);
                }

                i = j - 1;
            } else if (s.charAt(i) == '(') {
                stk.push(new HashMap<>());
            } else if (s.charAt(i) == ')') {
                Map<String, Integer> next = stk.pop();
                int j = i + 1;
                if (j < s.length() && Character.isDigit(s.charAt(j))) {
                    while (j < s.length() && Character.isDigit(s.charAt(j))) {
                        j++;
                    }
                    int num = Integer.valueOf(s.substring(i + 1, j));
                    for (String c : next.keySet()) {
                        next.put(c, next.get(c) * num);
                    }
                }
                i = j - 1;
                for (String c : next.keySet()) {
                    stk.peek().put(c, stk.peek().getOrDefault(c, 0) + next.get(c));
                }

            }
        }
        return stk.pop();
    }

    // H2O(Ca(OH)2)3
    public static void main(String[] args) {
        GetChemistryOccurance test = new GetChemistryOccurance();
        String s = "H2O(Ca(OH)2)3";
//        Map<String, Integer> map = test.getChemistryOccurance(s, dict);
        Map<String, Integer> map = test.iterativeWay(s);
        return;
    }
}
