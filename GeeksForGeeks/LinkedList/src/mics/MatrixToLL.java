package mics;

import java.util.HashMap;

public class MatrixToLL {
    // node of linked list
    static class Node {
        int data;
        public Node right;
        public Node down;

        Node(int data) {
            this.data = data;
        }
    }

    // driver program
    public static void main(String[] args) {
        // 2D matrix
        int[][] arr = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int m = 3, n = 3;
        Node head = construct(arr, m, n);
        //Debug this code to view the op

    }

    private static Node construct(int[][] arr, int m, int n) {
        HashMap<String, Node> hashMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Node nd = new Node(arr[i][j]);
                hashMap.put(i + "_" + j, nd);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Node nd = hashMap.get(i + "_" + j);
                if (j <= m - 1) {
                    int currJIndex = j + 1;
                    nd.right = hashMap.get(i + "_" + currJIndex);
                }
                if (i <= n - 1) {
                    int currIndex = i + 1;
                    nd.down = hashMap.get(currIndex + "_" + j);
                }
            }
        }


        return hashMap.get(0 + "_" + 0);
    }
}
