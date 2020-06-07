public class RemoveSpecificInstance {
    public static void main(String[] args) {
        int array[] = { 3, 2, 2, 3 };
        int specificInstance = 3;
        int count = remove(array, specificInstance);
        System.out.println(count);
    }

    private static int remove(int[] array, int specificInstance) {
        if (array.length == 0)
            return 0;

        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != specificInstance) {
                array[j] = array[i];
                j++;
            }
        }
        return j;
    }
}