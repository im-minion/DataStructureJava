public class FirstUniqueChar {
    public static void main(String[] args) {
        System.out.println(getFirstUniqueNumber("leetcode"));
        System.out.println(getFirstUniqueNumber("loveleetcode"));
    }

    private static int getFirstUniqueNumber(String test) {
        int result = -1;
        int fre[] = new int[26];
        for (int i = 0; i < test.length(); i++) {
            fre[test.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < test.length(); i++) {
            if (fre[test.charAt(i) - 'a'] == 1) {
                result = i;
                break;
            }
        }

        return result;
    }
}
