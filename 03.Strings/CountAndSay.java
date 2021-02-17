public class CountAndSay {
    public static void main(String[] args) {
        int test = 5;
        String output = countAndSay(test);
        System.out.println(output);
//         1, 11, 21, 1211, 111221, 312211
    }

    private static String countAndSay(int n) {
        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for (int i = 1; i < n; i++) {
            prev = curr;
            curr = new StringBuilder();
            count = 1;
            say = prev.charAt(0);
            for (int j = 1, len = prev.length(); j < len; j++) {
                if (prev.charAt(j) != say) {
                    curr.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                } else {
                    count++;
                }
            }
            curr.append(count).append(say);
        }
        return curr.toString();
    }

    private static String countAndSayIDidIt(int n) {
        if(n == 1) return "1";
        if(n == 2) return "11";
        String prev = "1";

        StringBuilder result = new StringBuilder("11");
        for(int i = 3 ; i <= n; i++) {
            prev = result.toString();
            result = new StringBuilder();
            int count = 1;
            String say = String.valueOf(prev.charAt(0));
            for(int j = 1; j < prev.length(); j++) {
                if(prev.charAt(j-1) == prev.charAt(j)) {
                    count++;
                } else {
                    result.append(count).append(say);
                    say = String.valueOf(prev.charAt(j));
                    count = 1;
                }
            }
            result.append(count).append(say);
        }
        return result.toString();
    }
}
