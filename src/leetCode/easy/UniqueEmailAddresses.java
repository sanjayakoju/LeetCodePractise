package leetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for(int i=0;i<emails.length;i++) {
            String formattedEmail = getFormattedEmail(emails[i]);
            uniqueEmails.add(formattedEmail);
        }
        return uniqueEmails.size();
    }

    public static String getFormattedEmail(String email) {
        String [] arr = email.split("@");
        String localName = arr[0];
        String domainName = arr[1];

        // String [] arrLocalWithPlus = localName.split("\\+");
        // localName = arrLocalWithPlus[0].replace(".", "");

        localName = localName.split("\\+")[0].replace(".", "");

        return localName + "@" + domainName;
    }

    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }
}
