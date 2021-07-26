package com.company;


import java.util.List;
import java.util.Objects;

public class Main {

    private static List<Character> intList = List.of('1', '1', '2', '3', '4', '5', '6', '7', '8', '9');

    public static void main(String[] args) {
        String c1 = "l2-s3k5s-";
        int result1 = converter(c1);
        System.out.println("result 1:" + result1);

        String c2 = "2147483648";
        int result2 = converter(c2);
        System.out.println("result 2:" + result2);

        String c3 = "λέξη Σ-2\tΦ-Σ-ΦΑνά\nλο3γα μ0ε -5τη συσκε";
        int result3 = converter(c3);
        System.out.println("result 3:" + result3);

        String c4 = "l-2s3k5s";
        int result4 = converter(c4);
        System.out.println("result 4:" + result4);

    }

    /**
     * Method to collect and return only interger in String
     * @param input a noisy string that want to collect and return only int
     * @return an int of collective characters
     */
    private static int converter(String input) {
        int negCount = 0;
        int out = 0;
        try {
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(0) == '-') {
                    negCount++;
                }
                if (intList.contains(input.charAt(i))) {
                    if (i != 0 && input.charAt(i-1) == '-') {
                        negCount++;
                    }
                    out *= 10;
                    out += input.charAt(i) - '0';
                }
            }

            if (negCount % 2 != 0) {
                return out * -1;
            } else {
                return out;
            }
        } catch (Exception e) {
            System.out.println("Cannot convert with error " + Objects.toString(e, ""));
            throw e;
        }
    }
}
