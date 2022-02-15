package medium;

import java.util.*;

public class Q_049_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> op = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);
            if (!map.containsKey(sortedStr)) {
                List<String> t = new ArrayList<>();
                t.add(str);
                map.put(sortedStr, t);
            } else {
                map.get(sortedStr).add(str);
            }
        }

        for (List<String> l : map.values()) {
            op.add(l);
        }

        return op;
    }
}
