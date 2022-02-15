package misc;

public class RemoveDuplicateFromSorted {
    public static void main(String[] args) {
        int array[] = { 1, 2, 3, 3, 4, 4 };
        int count = remove(array);
        System.out.println("Count : " + count);
    }

    private static int remove(int[] array) {
        if (array.length == 0)
            return 0;
        int j = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[j]) {
                array[++j] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        return ++j;
    }
}