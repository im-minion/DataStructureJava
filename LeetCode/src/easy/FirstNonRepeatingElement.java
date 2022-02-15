import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingElement {
    public static void main(String[] args) {

    }

    public int firstNonRepeating(int[] arr, int n) {
        // Complete the function
        Map<Integer, Integer> valToCount = new LinkedHashMap<>();

        for (int el : arr) {
            valToCount.put(el, valToCount.getOrDefault(el, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> m : valToCount.entrySet()) {
            if (m.getValue() == 1) {
                return m.getKey();
            }
        }
        return 0;
    }
}
