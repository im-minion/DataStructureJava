public class Q_058_LengthOfLastWord {
    public static void main(String[] args) {

    }

    public int lengthOfLastWord(String s) {
        //Solution 1

        // if(s == null) return 0;
        // String[] arr = s.split(" ");
        // if(arr.length == 0) return 0;
        // return arr[arr.length -1].length();

        //Solution 2 : more optimized
        s = s.trim();
        StringBuilder word = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ')
                word.append(String.valueOf(s.charAt(i)));
            else
                break;
        }

        return word.toString().length();

    }
}
