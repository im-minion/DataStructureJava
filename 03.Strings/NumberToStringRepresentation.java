public class NumberToStringRepresentation {

    final String[] tensNames = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty",
            " ninety" };
    final String[] numNames = { "", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine",
            " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen",
            " nineteen" };

    public static void main(String[] args) {
        NumberToStringRepresentation n = new NumberToStringRepresentation();
        System.out.println(n.convertLessThanOneThousand(146));
    }

    private String convertLessThanOneThousand(int number) {
        String soFar;
        if (number % 100 < 20) {
            soFar = numNames[number % 100];
            number = number / 100;
        } else {
            soFar = numNames[number % 10];
            number = number / 10;
            soFar = tensNames[number % 10] + soFar;
            number = number / 10;
        }
        if (number == 0)
            return soFar;
        return numNames[number] + " hundred" + soFar;
    }
}
