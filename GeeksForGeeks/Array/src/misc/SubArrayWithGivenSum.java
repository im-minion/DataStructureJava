package misc;

import java.util.ArrayList;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(subarraySum(arr, arr.length, 15));
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < n) {
            sum = sum + arr[j];
            if (sum == s) {
                //sout i and j
                result.add(i + 1);
                result.add(j + 1);
                break;
            } else if (sum > s) {
                while(sum > s) {
                    sum = sum - arr[i];
                    i++;
                }
                if (sum == s) {
                    result.add(i + 1);
                    result.add(j + 1);
                    break;
                }
                j++;
            } else if (sum < s) {
                j++;
            }
        }
        if(result.isEmpty())
            result.add(-1);
        return result;
    }
}
