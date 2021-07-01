/*Min Number of Flips

Given a binary string, that is it contains only 0s and 1s.
We need to make this string a sequence of alternate characters by flipping some of the bits,
our goal is to minimize the number of bits to be flipped.

Example 1:
Input:
S = "001"
Output: 1
Explanation: We can flip the 0th bit to 1
to have "101".

Example 2:
Input:
S = "0001010111"
Output: 2
Explanation: We can flip the 1st and 8th bit
to have "0101010101".

Your Task:
You don't need to read input or print anything.
Your task is to complete the function minFlips() which takes the string S as input and
returns the minimum number of flips required.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).


Constraints:
1<=|S|<=105

*/

public class MinFlips {
    public static void main(String[] args) {

    }

    public int minFlips(String S) {
        // Code here
        int a = 0;
        int b = 0;

        boolean isOne = true;
        for (char x : S.toCharArray()) { //start From 1
            if (isOne) {
                if (x != '1') {
                    a++;
                }
                isOne = false;
            } else {
                if (x != '0') {
                    a++;
                }
                isOne = true;
            }
        }

        isOne = false;
        for (char x : S.toCharArray()) { //start From 0
            if (isOne) {
                if (x != '1') {
                    b++;
                }
                isOne = false;
            } else {
                if (x != '0') {
                    b++;
                }
                isOne = true;
            }
        }

        return Math.min(a, b);
    }
}
