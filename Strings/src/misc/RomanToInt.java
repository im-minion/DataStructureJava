package misc;

public class RomanToInt {
    public static void main(String[] args) {
        int result = convertRomanToIn("LXXXVII");
        System.out.println(result);
        
        int result2 = convertRomanToIn("LXXXVIII");
        System.out.println(result2);
    }

    public static int convertRomanToIn(String s) {
        int sum = 0;
        /**
         * IV => 4
         * V => 5
         * IX => 9
         * X => 10
         * XL => 40
         * L => 50
         * XC => 90
         * C => 100
         * CD => 400
         * D => 500
         * CM => 900
         * M =>  1000 
         */
        if(s.contains("IV")) sum = sum - 2;
        if(s.contains("IX")) sum = sum - 2;
        if(s.contains("XL")) sum = sum - 20;
        if(s.contains("XC")) sum = sum - 20;
        if(s.contains("CD")) sum = sum - 200;
        if(s.contains("CM")) sum = sum - 200;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'I' ) sum = sum + 1;
            if(s.charAt(i) == 'V' ) sum = sum + 5;
            if(s.charAt(i) == 'X' ) sum = sum + 10;
            if(s.charAt(i) == 'L' ) sum = sum + 50;
            if(s.charAt(i) == 'C' ) sum = sum + 100;
            if(s.charAt(i) == 'D' ) sum = sum + 500;
            if(s.charAt(i) == 'M' ) sum = sum + 1000;
        }

        return sum;
    }
}
