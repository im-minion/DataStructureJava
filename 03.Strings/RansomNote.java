public class RansomNote {
    public static void main(String[] args) {
        boolean op = canConstruct("a", "b");
        System.out.println(op);
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
        System.out.println(canConstruct("abcd", "abcd"));
        System.out.println(canConstruct("yyyzzz", "zzzyyy"));
    }

    private static boolean canConstruct(String ransomString, String magazineString) {
        int arr[] = new int[26];
        for (int i = 0; i < magazineString.length(); i++) {
            arr[magazineString.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomString.length(); i++) {
            if (--arr[ransomString.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
