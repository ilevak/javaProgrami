/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ivale
 */
public class CountDuplicates {

    static final int NO_OF_CHARS = 256;
    /**
     * @param args the command line arguments
     */
    static String input = "";

    public static void main(String[] args) {
        input = buildString(args);
        printDuplicates();
    }

    private static String buildString(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (String s : args) {
            sb.append(s).append(" ");
        }
        return sb.toString().trim();
    }

    private static void printDuplicates() {
        int numberOfAsciiCharachters=256;
        int[] duplicates = new int[numberOfAsciiCharachters];
        countDuplicates(duplicates);
        for (int i = 0; i < numberOfAsciiCharachters; i++) {
            if (duplicates[i] > 1) {
                System.out.println((char) i +": "+duplicates[i]);
            }
        }
    }

    private static void countDuplicates(int[] duplicates) {
        for (int i = 0; i < input.length(); i++) {
            duplicates[input.charAt(i)]++;
        }
    }


   
}
