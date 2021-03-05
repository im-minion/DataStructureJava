package orderstatistics;

import java.util.Arrays;

/*
Median of Stream of Running Integers using STL
Difficulty Level : Hard

Given that integers are being read from a data stream.
Find the median of all the elements read so far starting from the first integer till the last integer.
This is also called the Median of Running Integers. The data stream can be any source of data,
for example, a file, an array of integers, input stream etc.

What is Median?

Median can be defined as the element in the data set which separates the higher half of the data sample from the lower half.
In other words, we can get the median element as, when the input size is odd, we take the middle element of sorted data.
If the input size is even, we pick an average of middle two elements in the sorted stream.

Examples:

Input: 5 10 15
Output: 5, 7.5, 10
Explanation:
Given the input stream as an array of integers [5,10,15].
Read integers one by one and print the median correspondingly.
So, after reading first element 5,median is 5.
After reading 10,median is 7.5 After reading 15, median is 10.

Input: 1, 2, 3, 4
Output: 1, 1.5, 2, 2.5
Explanation:
Given the input stream as an array of integers [1, 2, 3, 4].
Read integers one by one and print the median correspondingly. So, after reading first element 1,median is 1.
After reading 2, median is 1.5 After reading 3, median is 2. After reading 4, median is 2.5.
*/

public class MedianOfStream {
    public static void main(String[] args) {
        int[] arr = {5, 10, 15};
        double[] result = getMedianStream(arr);
        Arrays.stream(result).forEach(a -> System.out.print(a + " "));
    }

    private static double[] getMedianStream(int[] arr) {
        double[] res = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = findMedian(arr, i+1);
        }
        return res;
    }

    // Function for calculating median
    public static double findMedian(int[] a, int n) {
        if (n % 2 != 0) { // odd nums => middle elements 7/2=> 3rd ele
            return a[n / 2];
        } else { // even nums => find avg of middle elements 8/2 = 4 (index => 3rd and 4th)
            return (double) (a[(n / 2)] + a[(n - 1) / 2]) / 2;
        }
    }
}
