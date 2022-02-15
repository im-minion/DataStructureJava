package gfg.misc;

import java.util.ArrayList;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(subarraySum(arr, arr.length, 15));
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int currSum = 0;
        while (j < n) {
            currSum = currSum + arr[j];
            if (currSum == sum) {
                //sout i and j
                result.add(i + 1);
                result.add(j + 1);
                break;
            } else if (currSum > sum) {
                while(currSum > sum) {
                    currSum = currSum - arr[i];
                    i++;
                }
                if (currSum == sum) {
                    result.add(i + 1);
                    result.add(j + 1);
                    break;
                }
                j++;
            } else if (currSum < sum) {
                j++;
            }
        }
        if(result.isEmpty())
            result.add(-1);
        return result;
    }
}
