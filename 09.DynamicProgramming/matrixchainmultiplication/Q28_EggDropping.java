package matrixchainmultiplication;

import java.util.Arrays;

/*
Egg dropping problem using Dynamic Programming (DP)

In this article, we are going to implement a C++ program to solve the Egg dropping problem using dynamic programming (DP).
Submitted by Ritik Aggarwal, on December 13, 2018

Problem statement: You are given N floor and K eggs.
You have to minimize the number of times you have to drop the eggs to find the critical floor where critical floor
means the floor beyond which eggs start to break. Assumptions of the problem:

If egg breaks at ith floor then it also breaks at all greater floors.
If egg does not break at ith floor then it does not break at all lower floors.
Unbroken egg can be used again.
Note: You have to find minimum trials required to find the critical floor not the critical floor.

Constraints:

1 <= N <= 1000
1 <= K <= 100
Example 1:

Input:
4
2

Output:
Number of trials when number of eggs is 2 and number of floors is 4: 3
Example 2:

Input:
36
2

Output:
Number of trials when number of eggs is 2 and number of floors is 36: 8


Explanation of the problem:

For the Input 1,

Case 1. Drop at first floor:

Egg does not break:
If egg does not break then we have three floors left and two eggs.
We can either choose 2nd or 3rd floor and proceed similarly but we can easily see we have to do atleast 3 trials.
Egg breaks:
If egg breaks then we found the critical floor in only 1 trial.
In case 1, the worst possibility is that egg does not break so trials will be 3 for case 1.

Case 2. Drop at second floor:

Egg breaks:
We are left with one egg and we have to check only 1 floor so number of trials 2.
Egg does not break:
We still have two eggs and two floors to check we have to check one by one on these floors so trials needed are 3.
So for case 2 together the worst possibility is 3.

In the end we have to find the minimum of case 1, case 2, case 3, case 4.

Note: Dropping from 3rd and 4th floor is same as dropping from 2nd and 1st floor respectively only difference is
that subcases A and B just gets swapped.
*/
public class Q28_EggDropping {
    static int t[][];

    public static void main(String[] args) {
        int e = 2;
        int f = 4;
        int minFloor = solveByRecursion(e, f);
        System.out.println("solveByRecursion : " + minFloor);

        t = new int[e + 1][f + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        minFloor = solveByMemoize(e, f);
        System.out.println("solveByMemoize  : " + minFloor);
    }

    private static int solveByMemoize(int e, int f) {
        if (f == 1 || f == 0) {
            return f;
        }
        if (e == 1) {
            return f;
        }

        if (t[e][f] != -1) {
            return t[e][f];
        }
        int min = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int left = t[e - 1][k - 1] == -1 ? solveByRecursion(e - 1, k - 1) : t[e - 1][k - 1];
            if (t[e - 1][k - 1] == -1) {
                t[e - 1][k - 1] = left;
            }

            int right = t[e][f - k] == -1 ? solveByRecursion(e, f - k) : t[e][f - k];
            if (t[e][f - k] == -1) {
                t[e][f - k] = right;
            }

            int temp = 1 + Math.max(left, right);
            min = Math.min(min, temp);
        }
        return t[e][f] = min;
    }

    private static int solveByRecursion(int e, int f) {
        if (f == 1 || f == 0) {
            return f;
        }
        if (e == 1) {
            return f;
        }
        int min = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int temp = 1 + Math.max(solveByRecursion(e - 1, k - 1), solveByRecursion(e, f - k));
            min = Math.min(min, temp);
        }
        return min;
    }
}
