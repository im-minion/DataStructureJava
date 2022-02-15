package misc;/*
Check whether two strings are equivalent or not according to given condition
Difficulty Level : Easy
Last Updated : 30 Jul, 2019
Given two strings A and B of equal size.
Two strings are equivalent either of the following conditions hold true:
1) They both are equal. Or,
2) If we divide the string A into two contiguous substrings of same size A1 and A2 and string B into
 two contiguous substrings of same size B1 and B2, then one of the following should be correct:

A1 is recursively equivalent to B1 and A2 is recursively equivalent to B2
A1 is recursively equivalent to B2 and A2 is recursively equivalent to B1

Input : A = “aaba”, B = “abaa”
Output : YES
Explanation : Since condition 1 doesn’t hold true, we can divide string A into “aaba” = “aa” + “ba” and string B into “abaa” = “ab” + “aa”. Here, 2nd subcondition holds true where A1 is equal to B2 and A2 is recursively equal to B1

Input : A = “aabb”, B = “abab”
Output : NO

*/

public class AreTwoStringEqualWithCond {

    public static void main(String[] args) {
        String a = "aaba";
        String b = "abaa";
        if (areEquivalent(a, b))
            System.out.println("Yes");
        else
            System.out.println("No");

        a = "aabb";
        b = "abab";
        if (areEquivalent(a, b))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    // This function returns the least lexicographical String obtained from its two halves
    static String leastLexiString(String s) {
        // Base Case - If String size is 1
        if (s.length() == 1)
            return s;

        // Divide the String into its two halves
        String x = leastLexiString(s.substring(0,
                s.length() / 2));
        String y = leastLexiString(s.substring(s.length() / 2));

        // Form least lexicographical String
        return String.valueOf((x + y).compareTo(y + x));
    }

    static boolean areEquivalent(String a, String b) {
        return !(leastLexiString(a).equals(leastLexiString(b)));
    }

}
