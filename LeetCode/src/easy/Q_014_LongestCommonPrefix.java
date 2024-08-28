package easy;

import trie.TrieNode;

public class Q_014_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefixByTrie(strs));
    }

    private static String longestCommonPrefixByTrie(String[] strs) {
        TrieNode root = new TrieNode();
        StringBuilder op = new StringBuilder();

        for (String s : strs) {
            insert(s, root);
        }

        TrieNode curr = root;
        boolean continueLoop = true;
        do {
            int x = 0;
            int i = 0;
            int indexOfNotNull = 0;
            for ( i= 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    x++;
                    indexOfNotNull = i;
                }
            }
            if (x != 1) {
                continueLoop = false;
            } else {
                op.append(indexOfNotNull + 1);
                op.append(" ");
                curr = curr.children[indexOfNotNull];
            }
        } while (continueLoop && curr != null);

        return op.toString();
    }

    public static void insert(String word, TrieNode root) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String op = strs[0];

        for (String s : strs) {
            if (s == null || "".equals(s)) return "";
            String currPrev = "";
            int i = 0;
            while (i < op.length() && i < s.length() && op.charAt(i) == s.charAt(i)) {
                currPrev += op.charAt(i);
                i++;
            }
            if ("".equals(currPrev)) {
                return "";
            } else if (currPrev.length() < op.length()) {
                op = currPrev;
            }
        }
        return op;
    }
}
