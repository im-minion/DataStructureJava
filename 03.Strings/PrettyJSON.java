import java.util.ArrayList;

public class PrettyJSON {
    public static void main(String[] args) {
        ArrayList<String> ot = prettyJSON("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}");
        for (String x : ot) {
            System.out.println(x);
        }
    }

    public static ArrayList<String> prettyJSON(String A) {
        ArrayList<String> op = new ArrayList<String>();
        int n = A.length();
        int currSp = 0;
        String currSpaces = "";
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '{' || A.charAt(i) == '[') {

                currSpaces = currSpaces + "\t";
                currSp++;
                op.add(currSpaces + A.charAt(i));
            } else if (A.charAt(i) == '}' || A.charAt(i) == ']') {
                currSpaces = "";
                for (int j = 0; j < currSp; j++) {
                    currSpaces = currSpaces + "\t";
                }
                op.add(currSpaces + A.charAt(i));
            } else if (A.charAt(i) == ',') {
                op.set(op.size() - 1, op.get(op.size() - 1) + ",");
            } else {
                // append "word"
                String word = currSpaces;
                while (i < n && A.charAt(i) != '"') {
                    word = word + A.charAt(i);
                    i++;
                }
                while (i < n && A.charAt(i) != '"') {
                    word = word + A.charAt(i);
                    i++;
                }
                op.add(word);

            }
        }

        return op;
    }
}
