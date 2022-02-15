package misc;

public class Majority {
    public static void main(String[] args) {
        int array[] = { 1, 9, 1, 9, 1 };

        int result = getMajorElement(array);
        System.out.println(result);
    }

    static int getMajorElement(int a[]) {
        if (a.length == 0) {
            return 0;
        }
        int major = a[0];
        int count = 1;
        for (int i = 1; i < a.length; i++) {
            if (count == 0) {
                major = a[i];
            } else if (a[i] == major) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}