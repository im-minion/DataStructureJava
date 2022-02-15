package misc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReformattingDates {
    public static void main(String[] args) {
        List<String> ip = new ArrayList<>();
        ip.add("1st Mar 1984");
        ip.add("2nd Feb 2013");
        System.out.println(reformatDate(ip)); // op=> [1984-03-01, 2013-02-02]
    }

    public static List<String> reformatDate(List<String> dates) {
        // Write your code here
        List<String> outputDate = new ArrayList<>();

        try {
            for (String currDateToFormat : dates) {
                currDateToFormat = currDateToFormat.replace("st", "").replace("nd", "").replace("rd", "").replace("th", "");
                Date tempDate = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(currDateToFormat);
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Calendar tempC = Calendar.getInstance();
                tempC.setTime(tempDate);
                int year = tempC.get(Calendar.YEAR);
                if (year >= 1900 && year <= 2100) {
                    String dateStr = df.format(tempDate);
                    outputDate.add(dateStr);
                } else {
                    System.out.println("Year out of range");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return outputDate;
    }
}
