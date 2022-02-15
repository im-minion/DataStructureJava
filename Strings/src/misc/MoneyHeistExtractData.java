package misc;

import java.util.ArrayList;
import java.util.List;

public class MoneyHeistExtractData {
    public static void main(String[] args) {
        String hierarchy = "{\n    Money Heist\n    {\n        The most important character Professor\n    }\n    {\n        Another character is Berlin\n        {\n            Berlin is in charge of the heist\n        }\n    }\n    {\n        Another character is Moscow\n        {\n            Moscow is Denver's father\n        }\n    }\n    {\n        Another character is Rio\n        {\n            Rio is a computer programmer\n            {\n                Rio is also a good hacker\n                {\n                    Rio is very happy to be a part of the heist\n                }\n            }\n        }\n    }\n    {\n        Another character is Denver\n    }\n}\n";
        int level = 1;
        List<String> op = extractData(hierarchy, level);
        System.out.println(op);
    }

    private static List<String> extractData(String hierarchy, int level) {
        char[] arr = hierarchy.toCharArray();
        int currLevel = 0;
        List<String> op = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '{') {
                currLevel++;
            } else if (c == '}') {
                currLevel--;
            } else if (c == ' ') {

            } else if (currLevel == level) {
                StringBuilder currString = new StringBuilder();
                while (i < arr.length && (arr[i] != '{' && arr[i] != '}')) {
                    currString.append(arr[i]);
                    i++;
                }
                if (!(arr[i] != '{' && arr[i] != '}')) {
                    i--;
                }
                if (!"".equals(currString.toString().trim())) {
                    op.add(currString.toString().trim());
                }
            }
        }

        return op;
    }
}
