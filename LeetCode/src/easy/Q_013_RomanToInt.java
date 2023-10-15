package easy;

public class Q_013_RomanToInt {
    public static void main(String[] args) {

    }

    public int romanToInt(String s) {
        int res = 0;
        if (s.contains("IV")) res = res - 2;
        if (s.contains("IX")) res = res - 2;
        if (s.contains("XL")) res = res - 20;
        if (s.contains("XC")) res = res - 20;
        if (s.contains("CD")) res = res - 200;
        if (s.contains("CM")) res = res - 200;

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    res += 1;
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }
}
