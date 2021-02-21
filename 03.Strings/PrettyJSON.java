import java.util.ArrayList;

public class PrettyJSON {
    public static void main(String[] args) {
        ArrayList<String> ot = prettyJSON("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}");
        for (String x : ot) {
            System.out.println(x);
        }
    }

    public static ArrayList<String> prettyJSON(String json) {
        ArrayList<String> result = new ArrayList<String>();
        int multiplier = 0;
        int i = 0;

        while (i < (json.length())) {
            if (json.charAt(i) == '{' || json.charAt(i) == '[') {
                result.add(getSpaceString(multiplier) + json.charAt(i));
                multiplier += 1;
                i += 1;
            } else if (json.charAt(i) == '}' || json.charAt(i) == ']') {
                multiplier -= 1;
                result.add(getSpaceString(multiplier) + json.charAt(i));
                i += 1;
            } else if (json.charAt(i) == ',') {
                result.set(result.size() - 1, result.get(result.size() - 1) + ",");
                i += 1;
            } else {
                int start = i;
                while ((i < json.length()) && json.charAt(i) != ',' && json.charAt(i) != '{' && json.charAt(i) != '[' && json.charAt(i) != '}' && json.charAt(i) != ']') {
                    i += 1;
                }
                String curr_s = json.substring(start, i);
                result.add(getSpaceString(multiplier) + curr_s);
            }
        }

        return result;
    }

    private static String getSpaceString(int multiplier) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < multiplier; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }
}
