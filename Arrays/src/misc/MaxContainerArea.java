package misc;

public class MaxContainerArea {
    public static void main(String[] args) {
        int array[] = {3, 1, 2, 4, 5};
        int maxArea = getMaxArea(array);
        System.out.println(maxArea);
    }

    private static int getMaxArea(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(array[left], array[right]) * (right - left));
            if (array[left] < array[right]) {
                left++;
            } else {
                right--;
            }

        }
        return maxArea;
    }
}