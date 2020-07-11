/**
 * leetcode: https://leetcode.com/problems/goat-latin/
 * 
 * A sentence S is given, composed of words separated by spaces. Each word
 * consists of lowercase and uppercase letters only.
 * 
 * We would like to convert the sentence to "Goat Latin" (a made-up language
 * similar to Pig Latin.)
 * 
 * The rules of Goat Latin are as follows:
 * 
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of
 * the word. For example, the word 'apple' becomes 'applema'.
 * 
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter
 * and append it to the end, then add "ma". For example, the word "goat" becomes
 * "oatgma".
 * 
 * Add one letter 'a' to the end of each word per its word index in the
 * sentence, starting with 1. For example, the first word gets "a" added to the
 * end, the second word gets "aa" added to the end and so on. Return the final
 * sentence representing the conversion from S to Goat Latin.
 * 
 * 
 * Example 1:
 * 
 * Input: "I speak Goat Latin"
 * 
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * 
 * 
 * Example 2:
 * 
 * Input: "The quick brown fox jumped over the lazy dog"
 * 
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa
 * hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * 
 * 
 */

public class GoatLatin {
    public static void main(String[] args) {
        String output = goatLatin("I speak Goat Latin");
        System.out.println(output);
    }

    private static String goatLatin(String input) {
        String words[] = input.split(" ");
        StringBuilder outputSb = new StringBuilder("");
        for (int i = 0; i < words.length; i++) {
            StringBuilder currentWordSB = new StringBuilder(words[i]);
            if (words[i].startsWith("a") || words[i].startsWith("e") || words[i].startsWith("i")
                    || words[i].startsWith("o") || words[i].startsWith("u")) {

            } else {
                char firstChar = currentWordSB.charAt(0);
                currentWordSB.deleteCharAt(0);
                currentWordSB.append(firstChar);
            }

            currentWordSB.append("ma");

            for (int j = 0; j < i + 1; j++) {
                currentWordSB.append("a");
            }

            outputSb.append(currentWordSB.append(" "));

        }
        return outputSb.toString().trim();
    }
}