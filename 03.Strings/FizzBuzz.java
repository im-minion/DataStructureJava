import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        List<String> result = getFizzBuzz(17);
        result.forEach(r -> System.out.println(r));
    }

    private static List<String> getFizzBuzz(int n) {
        List<String> output = new ArrayList<>();
        for (int i = 1, fuzz = 0, buzz = 0; i <= n; i++) {
            fuzz++;
            buzz++;

            if (fuzz == 3 && buzz == 5) {
                output.add("FizzBuzz");
                fuzz = 0;
                buzz = 0;
            } else if (fuzz == 3) {
                output.add("Fizz");
                fuzz = 0;
            } else if (buzz == 5) {
                output.add("Buzz");
                buzz = 0;
            } else {
                output.add("" + i);
            }
        }
        return output;
    }
}
