
/**
 * leetCode URL: https://leetcode.com/problems/unique-email-addresses/
 * 
 * Every email consists of a local name and a domain name, separated by the @ sign.
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 * If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)
 * It is possible to use both of these rules at the same time.
 * Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails? 
 * Example 1:
 * Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 * 
 */

import java.util.HashSet;

public class UniqueEmails {
    public static void main(String[] args) {
        System.out.println("Unique Emails solution.");
        String[] emailList = new String[] { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
                "test.e.mail+alex@lee.tcode.com" };
        HashSet<String> emails = findUniqueEmails(emailList);
        for (String email : emails) {
            System.out.println(email);
        }
        System.out.println(emails.size());
    }

    private static HashSet<String> findUniqueEmails(String[] inputArray) {
        HashSet<String> outputSet = new HashSet<>();
        for (String email : inputArray) {
            int splitPosition = email.indexOf("@");
            String localName = email.substring(0, splitPosition);
            String domainName = email.substring(splitPosition);
            if (localName.indexOf("+") > 0) {
                int plusPosition = localName.indexOf("+");
                localName = localName.substring(0, plusPosition);
            }
            localName = localName.replaceAll("//.", "");
            outputSet.add(localName + domainName);
        }
        return outputSet;
    }
}