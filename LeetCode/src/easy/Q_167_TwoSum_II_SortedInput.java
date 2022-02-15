public class Q_167_TwoSum_II_SortedInput {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        int[] op = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        int sum;
        while ((!(i > j))) {
            sum = numbers[i] + numbers[j];
            if (sum > target)
                j--;
            else if (sum < target)
                i++;
            else {
                op[0] = i + 1;
                op[1] = j + 1;
                return op;
            }
        }
        return op;
    }
}
