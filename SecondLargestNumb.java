
/*
    Find second largest number in given integer array without sorting
    Input: numbers with whitespace as separator example: 1 2 12 2
 */
/**
 *
 * @author ivale
 */
public class SecondLargestNumb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] intArray = makeArray(args);
        int secondLargest = findSecondLargest(intArray);
        System.out.println("Second largest in given array is " + secondLargest);
    }

    private static int[] makeArray(String[] args) {
        int[] intArray = new int[args.length];
        for (int i = 0; i < intArray.length; i++) {
            if (checkIfNumber(args)) {
                intArray[i] = Integer.parseInt(args[i]);
            }
        }
        return intArray;
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

    private static int findSecondLargest(int[] intArray) {
        int firstLargest = 0;
        int secondLargest = 0;

        for (int i : intArray) {
            if (i >firstLargest) {
                secondLargest = firstLargest;
                firstLargest = i;
            } else if (i > secondLargest && i < firstLargest) {
                secondLargest = i;
            }
        }
        return secondLargest;
    }

}
