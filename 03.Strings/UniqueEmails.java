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
        for(String email: inputArray) {
            int splitPosition = email.indexOf("@");
            String localName = email.substring(0, splitPosition);
            String domainName = email.substring(splitPosition);
            if(localName.indexOf("+") > 0) {
                int plusPosition = localName.indexOf("+");
                localName = localName.substring(0, plusPosition);
            }
            localName = localName.replaceAll("//.", "");
            outputSet.add(localName + domainName);
        }
        return outputSet;
    }
}