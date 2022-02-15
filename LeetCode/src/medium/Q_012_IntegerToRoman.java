package medium;

public class Q_012_IntegerToRoman {
    public static void main(String[] args) {

    }

    public String intToRoman(int num) {
        StringBuilder output = new StringBuilder();
        String[] romanArray = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] numberArray = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; i < numberArray.length && num > 0; i++) {
            while (num >= numberArray[i]) {
                output.append(romanArray[i]);
                num = num - numberArray[i];
            }
        }
        return output.toString();
    }
}
