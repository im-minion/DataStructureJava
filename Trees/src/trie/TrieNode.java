package trie;

public class TrieNode {
    public TrieNode[] children;

   public boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }

}
class Trie{

    private final TrieNode root;

    Trie() {
        root = new TrieNode();
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        boolean isPresent = trie.search("hello");
        System.out.println(isPresent);
    }

    private void insert(String word) {
        TrieNode node = root;
        for (int i = 0 ; i < word.length() ; i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    private boolean search(String word) {
        TrieNode node = root;
        for (int i = 0 ; i < word.length() ; i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

}
