package fibonacci;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ivale
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    static List<Integer> fibonacciNumbList = new ArrayList<>();
    static int numb;

    public static void main(String[] args) {
        if (validateArgs(args)) {
            String strNum = args[0];
            numb = Integer.parseInt(strNum);
            System.out.println("Fibonacci sequence will be upto number: " + numb);
            makeFibonacci2();
            //makeFibonacci()
            printFibonacci();

        }
    }

    private static boolean validateArgs(String[] args) {
        if (args.length != 1) {
            System.err.println("You entered more than one paramter or zero parameters!");
            return false;
        } else if (!checkIfNumber(args)) {
            System.err.println("Entered parameter was not a number!");
            return false;
        } else {
            return true;
        }

    }

    private static boolean checkIfNumber(String[] args) {
        String str = args[0];
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException n) {
            return false;
        }
    }

    /*
    *this method uses variables and with them sets value of next fibonacci number
    */
    private static void makeFibonacci() {
        int previousNumb = 0;
        int secondPreviousnumb = 1;
        int fibonacciNumb = 0;
        for (int i = 0; i < numb; i++) {
            fibonacciNumb = secondPreviousnumb + previousNumb;
            secondPreviousnumb = previousNumb;
            previousNumb = fibonacciNumb;
            fibonacciNumbList.add(fibonacciNumb);
        }

    }

    /*
        *this method uses values in list and with them sets value of next fibonacci number
     */
    private static void makeFibonacci2() {
        for (int i = 0; i < numb; i++) {
            fibonacciNumbList.add(findNextFibonnaciNumb(i));
        }
    }

    private static int findNextFibonnaciNumb(int i) {

        if (i == 0 || i == 1) {
            return 1;
        } else {
            return findNumbWithList(i);
        }
    }

    private static int findNumbWithList(int i) {
        int indexOfPreviousNumber = i - 1;
        int indexOfSecondPreviousNumber = i - 2;
        int previousNumb = fibonacciNumbList.get(indexOfPreviousNumber);
        int secondPreviousNumb = fibonacciNumbList.get(indexOfSecondPreviousNumber);
        return previousNumb + secondPreviousNumb;
    }

    private static void printFibonacci() {
        System.out.println("Fibonacci sequence:");
        for (Integer i : fibonacciNumbList) {
            System.out.print(i + " ");
        }
    }
}
