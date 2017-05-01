package b;

import java.util.*;

public class WordAbbreviation {
    public List<String> wordsAbbreviation(List<String> dict) {
        Map<String, List<Integer>> abbreviationIndexMap = new HashMap<>(dict.size());
        for (int i = 0; i < dict.size(); i++) {
            String str = dict.get(i);
            String abbreviation = getAbbreviation(str, 1);
            List<Integer> indexList = abbreviationIndexMap.getOrDefault(abbreviation, new ArrayList<>());
            indexList.add(i);
            abbreviationIndexMap.put(abbreviation, indexList);
        }

        String[] res = new String[dict.size()];
        for (String abbreviation : abbreviationIndexMap.keySet()) {
            List<Integer> indexList = abbreviationIndexMap.get(abbreviation);
            if (indexList.size() == 1) {
                res[indexList.get(0)] = abbreviation;
                continue;
            }
            Map<Integer, String> resolvedAbbreviations = resolveConflict(abbreviation, indexList, 1, dict);
            for (int index : resolvedAbbreviations.keySet()) {
                res[index] = resolvedAbbreviations.get(index);
            }
        }

        return Arrays.asList(res);
    }

    private Map<Integer, String> resolveConflict(
            String abbreviation, List<Integer> indexList, int prefixLength, List<String> dict) {
        Map<Integer, String> res = new HashMap<>(indexList.size());
        if (indexList.size() == 1) {
            res.put(indexList.get(0), abbreviation);
            return res;
        }
        Map<String, List<Integer>> indexMap = new HashMap<>();
        for (int i : indexList) {
            String newAbbreviation = getAbbreviation(dict.get(i), prefixLength + 1);
            List<Integer> newIndexList = indexMap.getOrDefault(newAbbreviation, new ArrayList<>());
            newIndexList.add(i);
            indexMap.put(newAbbreviation, newIndexList);
        }
        for (String abbr : indexMap.keySet()) {
            List<Integer> newIndexList = indexMap.get(abbr);
            if (newIndexList.size() == 1) {
                res.put(newIndexList.get(0), abbr);
            } else {
                res.putAll(resolveConflict(abbr, newIndexList, prefixLength + 1, dict));
            }
        }
        return res;
    }

    private String getAbbreviation(String str, int prefixLength) {
        if (prefixLength >= str.length() - 2) {
            return str;
        }
        return new StringBuilder()
                .append(str.substring(0, prefixLength))
                .append(str.length() - prefixLength - 1)
                .append(str.charAt(str.length() - 1))
                .toString();
    }
}
