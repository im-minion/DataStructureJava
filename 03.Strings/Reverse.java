public class Reverse {
    public static void main(String[] args) {
        System.out.println("Reverse string solution using two pointer approach.");
        String rev = reverse("Testing");
        System.out.println(rev);
    }

    private static String reverse(String input) {
        int left = 0;
        int right = input.length() - 1;
        char[] inputArray = input.toCharArray();
        while (left <= right) {
            // swap char at left to char atright
            char temp = inputArray[left];
            inputArray[left] = inputArray[right];
            inputArray[right] = temp;
            right--;
            left++;
        }

        return String.valueOf(inputArray);
    }
}