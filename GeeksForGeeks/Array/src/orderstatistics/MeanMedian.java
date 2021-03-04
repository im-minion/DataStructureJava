package orderstatistics;

/*
Program for Mean and median of an unsorted array
Difficulty Level : Basic

Given n size unsorted array, find it’s mean and median.

Mean of an array = (sum of all elements) / (number of elements)

Median of a sorted array of size n is defined as the middle element when n is odd and average of middle two elements when n is even.
Since the array is not sorted here, we sort the array first, then apply above formula.
Input  : a[] = {1, 3, 4, 2, 6, 5, 8, 7}
Output : Mean = 4.5
         Median = 4.5
Sum of the elements is 1 + 3 + 4 + 2 + 6 + 5 + 8 + 7 = 36
Mean = 36/8 = 4.5
Since number of elements are even, median
is average of 4th and 5th largest elements.
which means (4 + 5)/2 = 4.5

Input  : a[] = {4, 4, 4, 4, 4}
Output : Mean = 4
         Median = 4
*/
public class MeanMedian {
    public static void main(String[] args) {

        int[] a = {1, 3, 4, 2, 7, 5, 8, 6};
        int n = a.length;

        // Function call
        System.out.println("Mean = " + findMean(a, n));
        System.out.println("Median = " + findMedian(a, n));
    }

    // Function for calculating mean
    public static double findMean(int[] a, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += a[i];

        return (double) sum / (double) n;
    }

    // Function for calculating median
    public static double findMedian(int[] a, int n) {
        if (n % 2 != 0) { //odd nums => middle elements 7/2=> 3rd ele
            return a[n / 2];
        } else {// even nums => find avg of middle elements 8/2 = 4 (index => 3rd and 4th)
            return (double) (a[(n / 2)] + a[(n - 1) / 2]) / 2;
        }
    }


}
