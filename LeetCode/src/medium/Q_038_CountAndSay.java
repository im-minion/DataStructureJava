package medium;

public class Q_038_CountAndSay {
    public static void main(String[] args) {

    }

    public String countAndSay(int n) {
        if (n == 1) return "1"; // answer for n = 1
        String prev;
        StringBuilder op = new StringBuilder("11");  // answer for n = 2

        for (int i = 3; i <= n; i++) {
            prev = op.toString();
            op = new StringBuilder();
            int count = 1;
            char c = prev.charAt(0);
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j - 1) == prev.charAt(j)) {
                    count++;
                } else {
                    op.append(count).append(String.valueOf(c));
                    count = 1;
                    c = prev.charAt(j);
                }
            }
            op.append(count).append(String.valueOf(c));
        }

        return op.toString();
    }

}
