package standard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class G07_HuffmanCoding {
    public static void main(String[] args) {
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charFreq = {5, 9, 12, 13, 16, 45};

        solveHuffmanCoding(charArray, charFreq);
    }

    // O(nlogn)
    private static void solveHuffmanCoding(char[] charArray, int[] charFreq) {
        int n = charArray.length;
        // min heap
        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, Comparator.comparingInt(o -> o.data));
        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.data = charFreq[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }
        HuffmanNode root = null;
        while (q.size() > 1) {
            // first min extract.
            HuffmanNode x = q.peek();
            q.poll();

            // second min extract.
            HuffmanNode y = q.peek();
            q.poll();

            HuffmanNode sumNode = new HuffmanNode();
            sumNode.data = x.data + y.data;
            sumNode.c = '-'; //placeholder

            sumNode.left = x;
            sumNode.right = y;

            root = sumNode;
            q.add(sumNode);
        }
        printNodes(root, "");
    }

    private static void printNodes(HuffmanNode root, String op) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            // c is the character in the node
            System.out.println(root.c + ":" + op);

            return;
        }

        // if we go to left then add "0" to the code.
        // if we go to the right add"1" to the code.

        // recursive calls for left and
        // right sub-tree of the generated tree.
        printNodes(root.left, op + "0");
        printNodes(root.right, op + "1");
    }

    static class HuffmanNode {

        int data;
        char c;

        HuffmanNode left;
        HuffmanNode right;
    }
}
