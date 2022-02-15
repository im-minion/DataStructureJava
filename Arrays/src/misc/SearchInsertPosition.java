package misc;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int array[] = { 1, 2, 3, 5 };
        int elementToInsert = 0;
        int position = getInsertPosition(array, elementToInsert);
        System.out.println(position);
    }

    private static int getInsertPosition(int[] array, int elementToInsert) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == elementToInsert) {
                return mid;
            }
            if (array[mid] >= elementToInsert) {
                high = mid - 1;
            } else if (array[mid] < elementToInsert) {
                low = mid + 1;
            }
        }
        return low;
    }
}