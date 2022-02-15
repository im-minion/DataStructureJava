package misc;

/**
 * Long Pressed Name
 * 
 * Your friend is typing his name into a keyboard. Sometimes, when typing a
 * character c, the key might get long pressed, and the character will be typed
 * 1 or more times.
 * 
 * You examine the typed characters of the keyboard. Return True if it is
 * possible that it was your friends name, with some characters (possibly none)
 * being long pressed.
 * 
 * 
 * 
 * Example 1: Input: name = "alex", typed = "aaleex" Output: true Explanation:
 * 'a' and 'e' in 'alex' were long pressed.
 * 
 * Example 2: Input: name = "saeed", typed = "ssaaedd" Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed
 * output.
 * 
 * Example 3: Input: name = "leelee", typed = "lleeelee" Output: true
 * 
 * Example 4: Input: name = "laiden", typed = "laiden" Output: true Explanation:
 * It's not necessary to long press any character.
 */
public class LongPressedName {
    public static void main(String[] args) {
        boolean result = isLongPressedName("alex", "aaleex");
        System.out.println(result);
        System.out.println(isLongPressedName("saeed", "ssaaedd"));
        System.out.println(isLongPressedName("leelee", "leelee"));
        System.out.println(isLongPressedName("laiden", "laiden"));
        System.out.println(isLongPressedName("vtkgn", "vttkgnn"));
    }

    private static boolean isLongPressedName(String name, String typed) {
        if (name.equals(typed))
            return true;
        if (name == null || typed == null || name.length() > typed.length())
            return false;

        int nPointer = 0;
        int tPointer = 0;
        while (tPointer < typed.length()) {
            if (nPointer < name.length() && typed.charAt(tPointer) == name.charAt(nPointer)) {
                nPointer++;
            } else if (tPointer == 0 || typed.charAt(tPointer) != typed.charAt(tPointer - 1)) {
                return false;
            }

            tPointer++;
        }

        return nPointer == name.length();
    }
}