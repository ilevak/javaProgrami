/*
 * Ulazna linija: recenica
*   Izlaz: obrnuta recenica (iva-->avi)
 */
package reverseString;

import java.util.ArrayList;

/**
 *
 * @author ivale
 */
public class ReverseString {

    /**
     * @param args the command line arguments
     */
    static String input;

    public static void main(String[] args) {
        if (validateString(args)) {
            input = buildString(args);
            System.out.println("First method without inbuilt reverse() StringBuilder method: " + reverseString1());
            System.out.println("Second method with inbuilt StringBuilder method(reverse()): " + reverseString2());
            System.out.println("Third method with  CharArray: " + reverseString3());
        }
    }

    private static boolean validateString(String[] args) {
        return args.length != 0;
    }

    private static String buildString(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (String s : args) {
            sb.append(s).append(" ");
        }
        return sb.toString().trim();
    }

    private static String reverseString1() {
        String reverseString = "";
        int inputLength = input.length();
        int index = 0;
        for (; inputLength > 0; inputLength--) {
            index = inputLength - 1;
            reverseString = reverseString + input.charAt(index);
        }
        return reverseString;
    }

    private static String reverseString2() {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb.reverse();
        return sb.toString();
    }

    private static String reverseString3() {
        String reverseString = "";
        char[] charachters = input.toCharArray();
        int charLength = charachters.length;
        int index;
        for (; charLength > 0; charLength--) {
            index = charLength - 1;
            reverseString = reverseString + charachters[index];
        }
        return reverseString;
    }

}
