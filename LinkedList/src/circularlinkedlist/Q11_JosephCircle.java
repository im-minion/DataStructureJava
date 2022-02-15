package circularlinkedlist;

import linkedlist.Node;
import linkedlist.Q1_LinkedList;

/*
Josephus Circle using circular linked list
Difficulty Level : Medium

There are n people standing in a circle waiting to be executed.
The counting out begins at some point in the circle and proceeds around the circle in a fixed direction.
In each step, a certain number of people are skipped and the next person is executed.
The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed),
until only the last person remains, who is given freedom.
Given the total number of persons n and a number m which indicates that m-1 persons are skipped and m-th person is killed in circle.
The task is to choose the place in the initial circle so that you are the last one remaining and so survive.
Examples :

Input : Length of circle : n = 4
Count to choose next : m = 2
Output : 1

Input : n = 5
m = 3
Output : 4
*/
public class Q11_JosephCircle {
    public static void main(String[] args) {
        int n = 14, m = 2;
        int op = getJosephusPosition(m, n);
        System.out.println(op);
    }

    private static int getJosephusPosition(int m, int n) {
        int op = 0;
        Q1_LinkedList list = new Q1_LinkedList();

        for (int i = 1; i <= n; i++) {
            list.cllPushEnd(i);
        }
        Q1_LinkedList.printCircularLinkedList(list.head);

        Node nd = list.head;
        while (list.head.next != list.head) {
            Node prevNodeDelete;
            for (int i = 0; i < m - 1; i++) {
                prevNodeDelete = nd.next;
            }

        }

        return op;
    }
}
