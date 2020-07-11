public class RotateString {
    public static void main(String[] args) {
        boolean isRotate = isRotateString("abcde", "cdeab");
        System.out.println(isRotate);
    }

    private static boolean isRotateString(String A, String B) {
        return (A.length() == B.length() && (A + A).contains(B));
    }
}