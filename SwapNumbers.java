/*
 * Ulazna linija: 2 broja odvojena razmakom
 * Zamijenjuju se brojevi, putem dodatne varijable ili bez
 */
package swapNumbers;

/**
 *
 * @author ivale
 */
public class SwapNumbers {

    /**
     * @param args the command line arguments
     */
    static int numb1;
    static int numb2;

    public static void main(String[] args) {
        if (validateArgs(args)) {

            numb1 = Integer.parseInt(args[0]);
            numb2 = Integer.parseInt(args[1]);

            System.err.println("First number : " + numb1 + " Second number : " + numb2);
            
            swapNumbers1();

            System.err.println("First number : " + numb1 + " Second number : " + numb2);
            
            swapNumbers2();
            
            System.err.println("First number : " + numb1 + " Second number : " + numb2);
        }
    }

    private static boolean validateArgs(String[] args) {
        if (args.length != 2) {
            System.err.println("You entered more or less than two paramters!");
            return false;
        } else {
            for (int i = 0; i < args.length; i++) {
                return checkIfNumber(args[i]);
            }
        }
        return false;
    }

    private static boolean checkIfNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException n) {
            System.err.println("Input : " + str + " is not a number!");
            return false;
        }
    }

    /*
    with additional variable
    */
    private static void swapNumbers1() {
        int temp = numb1;
        numb1 = numb2;
        numb2 = temp;
    }

    /*
    without additional variable
    */
    private static void swapNumbers2() {
        numb1=numb2+numb1;
        numb2=numb1-numb2;
        numb1=numb1-numb2;
    }
}
