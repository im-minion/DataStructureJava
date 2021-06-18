public class Q_011_ContainerWithMostWater {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int op = 0;

        while (left < right) {
            op = Math.max(op, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return op;
    }
}
