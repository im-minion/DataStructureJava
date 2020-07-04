public class ReverseUsingTwoPointers {
    public static void main(String[] args) {
        String input = "Testing is bad thing";
        System.out.println("Reverse string solution using Two Pointer Approach. \nInput : \n" + input + "\nOutput :");
        String rev = reverse(input);
        System.out.println(rev);
    }

    private static String reverse(String input) {
        int left = 0;
        int right = input.length() - 1;
        char[] inputArray = input.toCharArray();
        while (left <= right) {
            // swap char at left to char at right
            char temp = inputArray[left];
            inputArray[left] = inputArray[right];
            inputArray[right] = temp;
            right--;
            left++;
        }

        return String.valueOf(inputArray);
    }
}