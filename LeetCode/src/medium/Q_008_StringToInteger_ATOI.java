package medium;

public class Q_008_StringToInteger_ATOI {
    public static void main(String[] args) {
        String a = "  4   ";
        System.out.println(myAtoi(a));
    }
    public static int myAtoi(String s) {
        int op = 0;
        if(s == null) return op;
        s = s.trim();
        if(s.length() == 0) return op;
        boolean isNeg = s.charAt(0) == '-' ? true: false;
        if(s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        long num = 0;
        for(char c: s.toCharArray()) {
            if(Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                if(num > Integer.MAX_VALUE) {
                    return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                op = (int)num;
            } else {
                op = (int) num;
                break;
            }
        }

        return isNeg ? -op : op;
    }
}
