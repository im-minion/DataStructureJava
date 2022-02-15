package medium;

import java.util.*;

public class Q_017_LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> op;
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));

        switch (digits.length()) {
            case 0:
                return new ArrayList<>();
            case 1:
                return map.get(digits.charAt(0));
            case 2:
                op = new ArrayList<>();
                List<String> first = map.get(digits.charAt(0));
                List<String> second = map.get(digits.charAt(1));
                for (String s1 : first) {
                    for (String s2 : second) {
                        op.add(s1 + s2);
                    }
                }

                break;
            case 3:
                op = new ArrayList<>();
                List<String> fst = map.get(digits.charAt(0));
                List<String> scd = map.get(digits.charAt(1));
                List<String> trd = map.get(digits.charAt(2));
                for (String s1 : fst) {
                    for (String s2 : scd) {
                        for (String s3 : trd) {
                            op.add(s1 + s2 + s3);
                        }
                    }
                }
                break;
            case 4:
                op = new ArrayList<>();
                List<String> f = map.get(digits.charAt(0));
                List<String> s = map.get(digits.charAt(1));
                List<String> t = map.get(digits.charAt(2));
                List<String> foth = map.get(digits.charAt(3));
                for (String s1 : f) {
                    for (String s2 : s) {
                        for (String s3 : t) {
                            for (String s4 : foth) {
                                op.add(s1 + s2 + s3 + s4);
                            }
                        }
                    }
                }
                break;
            default:
                op = new ArrayList<>();
        }
        return op;

    }
}
