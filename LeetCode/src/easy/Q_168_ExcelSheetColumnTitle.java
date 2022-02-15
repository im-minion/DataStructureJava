import java.util.HashMap;
import java.util.Map;

public class Q_168_ExcelSheetColumnTitle {
    public static void main(String[] args) {

    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int mtpr = 1;
        Map<Integer, Character> m = new HashMap<>();
        int r = 1;
        for(int z = 'A'; z <= 'Z'; z++) {
            m.put(r++, (char)z);
        }
        while(columnNumber >= 1) {
            int curr = columnNumber % 26;
            sb.append(m.get(curr));
            columnNumber = columnNumber / 26;
        }
        return sb.reverse().toString();
    }
}
