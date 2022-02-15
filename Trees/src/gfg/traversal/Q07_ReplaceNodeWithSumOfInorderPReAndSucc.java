package gfg.traversal;

/*
TODO:
Replace each node in binary tree with the sum of its inorder predecessor and successor
    Difficulty Level : Medium
    Last Updated : 23 Oct, 2019
    Given a binary tree containing n nodes.
    The problem is to replace each node in the binary tree with the sum of its inorder predecessor and inorder successor.

    Examples:

    Input :
        1
      /   \
     2     3
    /  \  /  \
   4   5  6   7


    Output :
    inorder is                  4 2 5 1  6  3  7

    result inorder should be    2 9 3 11 4 13  3
       11
     /    \
     9      13
    / \    /  \
   2   3   4   3

    For 1:
    Inorder predecessor = 5
    Inorder successor  = 6
    Sum = 11

    For 4:
    Inorder predecessor = 0
    (as inorder predecessor is not present)
    Inorder successor  = 2
    Sum = 2

    For 7:
    Inorder predecessor = 3
    Inorder successor  = 0
    (as inorder successor is not present)
    Sum = 3*/
public class Q07_ReplaceNodeWithSumOfInorderPReAndSucc {
    public static void main(String[] args) {

    }
}
