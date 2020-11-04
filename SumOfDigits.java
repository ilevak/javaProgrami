/*
 * Ulazna linija: broj
 * Izlaz: suma znamenki broja
 */

/**
 *
 * @author ivale
 */
public class SumOfDigits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        calculateSum(args[0]);
        System.out.println(recursiveCalculateSum(Integer.parseInt(args[0])));
    }

    private static void calculateSum(String arg) {
        int digitNumber = arg.length();
        int sum = 0;
        int numb = Integer.parseInt(arg);
        int digit;
        for (int i = 0; i < digitNumber; i++) {
            digit = numb % 10;
            sum += digit;
            numb = (numb - digit) / 10;
        }
        System.out.println("Suma znamenki broja: " + arg + " je :" + sum);
    }

    static int sum2 = 0;

    private static int recursiveCalculateSum(int numb) {
        if (numb == 0) {
            return sum2;
        } else {
            int digit = numb % 10;
            sum2 += digit;
            recursiveCalculateSum(numb / 10);

        }
        return sum2;

    }

}
