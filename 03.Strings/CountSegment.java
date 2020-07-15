/**
 * 
 * Number of Segments in a String
 * 
 * 
 * Count the number of segments in a string, where a segment is defined to be a
 * contiguous sequence of non-space characters.
 * 
 * Please note that the string does not contain any non-printable characters.
 * 
 * Example:
 * 
 * Input: "Hello, my name is John" Output: 5
 */

public class CountSegment {
    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));
        System.out.println(countSegments(", , , ,        a, eaefa"));
        
    }

    public static int countSegments(String s) {
        if (s == null || s == "" || s.length() == 0)
            return 0;
        int result = 0;
        String[] temp = s.split(" ");
        for(String str: temp) {
            if(!str.equals(""))
                result++;
        }
        return result;
    }
}