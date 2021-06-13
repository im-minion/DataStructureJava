package misc;

import java.util.ArrayList;
import java.util.List;

public class SplitMachine {
    public static void main(String[] args) {
        List<String> ip = new ArrayList<>();
//        ip.add("712");
//        ip.add("246");
//        ip.add("365");
//        ip.add("312");

        ip.add("123");
        ip.add("123");
        ip.add("123");
        ip.add("123");

        int op = solve(ip);
        System.out.println(op);
    }

    private static int solve(List<String> ip) {
        MyKlass myKlass = new MyKlass();
        myKlass.currLen = ip.get(0).length();
        solveByRec(myKlass, ip);
        return myKlass.sum;
    }

    private static void solveByRec(MyKlass myKlass, List<String> ip) {
        // base cond
        if (ip.size() > 0 && ip.get(0).length() == 0) return;

        //solution
        int i = 0;
        int thisIterMax = Integer.MIN_VALUE;
        for (String a : ip) {
            String t = a;
            int currMax = getMaxFromString(t);
            String newString = getNewStringByRemovingMax(t, currMax);
            ip.set(i, newString);
            thisIterMax = Math.max(thisIterMax, currMax);
            i++;
        }
        myKlass.sum += thisIterMax;
        solveByRec(myKlass, ip);
    }

    private static String getNewStringByRemovingMax(String t, int currMax) {
        StringBuilder newStr = new StringBuilder();
        boolean flag = true;
        for (char c : t.toCharArray()) {
            if (flag && ((int) (c - '0')) == currMax) {
                //don't add
                flag = false;
            } else {
                newStr.append(c);
            }
        }
        return newStr.toString();
    }

    private static int getMaxFromString(String t) {
        char[] arr = t.toCharArray();
        int max = Integer.MIN_VALUE;
        for (char c : arr) {
            max = Math.max(max, (int) (c - '0'));
        }
        return max;
    }

    static class MyKlass {
        int sum = 0;
        int currLen;
    }
}
