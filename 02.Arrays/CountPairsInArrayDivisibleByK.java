public class CountPairsInArrayDivisibleByK {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 7, 5, 3};
        System.out.println(countKdivPairs(arr, arr.length, 4));
    }

    public static int countKdivPairs(int[] arr, int n, int k) {
        int[] freq = new int[k];

        // Count occurrences of all remainders
        for (int i = 0; i < n; i++)
            ++freq[arr[i] % k];

        // If both pairs are divisible by 'k'
        int sum = freq[0] * (freq[0] - 1) / 2;

        // count for all i and (k-i)
        // freq pairs
        for (int i = 1; i <= k / 2 && i != (k - i); i++)
            sum += freq[i] * freq[k - i];
        // If k is even
        if (k % 2 == 0)
            sum += (freq[k / 2] * (freq[k / 2] - 1) / 2);
        return sum;
    }
}
