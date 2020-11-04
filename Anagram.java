
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *Ulazne recenice moraju biti odvojene ";" npr. Iva Levak; keavaliv
 */
/**
 *
 * @author ivale
 */
public class Anagram {

    /**
     * @param args the command line arguments
     */
    static String str1;
    static String str2;

    public static void main(String[] args) {
        String input = buildString(args);
        String[] strings = input.split(";");

        str1 = strings[0].replace(" ", "").toLowerCase();
        str2 = strings[1].replace(" ", "").toLowerCase();
        if (checkLength() && checkAnagrams1()) {
            System.out.println(strings[0] + "  is anagram from " + strings[1]);
        } else {
            System.out.println(strings[0] + "  is not anagram from " + strings[1]);
        }

    }

    private static String buildString(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (String s : args) {
            sb.append(s).append(" ");
        }
        return sb.toString().trim();
    }

    private static boolean checkLength() {
        return str1.length() == str2.length();
    }

    /**
     * Pomocu usporedivanja array-a nakon sortiranja, ovo mi je najdrazi <3
     */
    private static boolean checkAnagrams1() {
        char[] str1Array = str1.toCharArray();
        char[] str2Array = str2.toCharArray();
        Arrays.sort(str1Array);
        Arrays.sort(str2Array);
        return Arrays.equals(str1Array, str2Array);
    }

    /**
     * pomocu charArray, i brisanja iz stringa jednog po jednog slova
     */
    private static boolean checkAnagrams2() {
        char[] str1Array = str1.toCharArray();
        for (int i = 0; i < str1Array.length; i++) {
            if (str2.indexOf(str1Array[i]) != -1) {
                str2 = str2.substring(0, str2.indexOf(str1Array[i])) + str2.substring(str2.indexOf(str1Array[i]) + 1, str2.length());
            }
        }
        return str2.isBlank();

    }

    /**
     * Pomocu brisanja sa stringBuilderom
     */
    private static boolean checkAnagrams3() {
        System.out.println(str2);
        String[] str1Array = str1.split("");
        StringBuilder sb2 = new StringBuilder(str2);
        for (String s : str1Array) {
            if (sb2.indexOf(s) != -1) {
                sb2.deleteCharAt(sb2.indexOf(s));
            }
        }
        return sb2.length() == 0;

    }

    /**
     * Pomocu brisanja unutar liste
     */
    private static boolean checkAnagrams4() {
        List<String> stringList1 = new ArrayList<>();
        stringList1.addAll(Arrays.asList(str1.split("")));
        String[] str2Array = str2.split("");
        for (String s : str2Array) {
            if (stringList1.contains(s)) {
                stringList1.remove(s);
            }
        }
        return stringList1.isEmpty();
    }

}
