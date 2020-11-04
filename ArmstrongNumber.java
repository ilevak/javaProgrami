/*
 *Ulazna linija: broj
 *Provjerava je li broj armstrongov broj
 */

/**
 *153 je, 154 nije
 * @author ivale
 */
public class ArmstrongNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (checkIfItsArmstrong2(Integer.parseInt(args[0]))) {

            System.out.println(args[0] + " is Armstrong number");
        } else {
            System.out.println(args[0] + " is not Armstrong number");
        }
    }

    /**
     * Using mostly strings
     */
    private static boolean checkIfItsArmstrong(String upisaniBroj) {
        int brojZnamenki = upisaniBroj.length();
        int broj = Integer.parseInt(upisaniBroj);
        String[] znamenke = upisaniBroj.split("");
        float zbroj = 0;
        for (String znamenka : znamenke) {
            zbroj += Math.pow(Integer.parseInt(znamenka), brojZnamenki);
        }
        return zbroj == broj;
    }

    /**
     * Using mostly integer
     */
    private static boolean checkIfItsArmstrong2(int upisaniBroj) {
        int brojZnamenki = String.valueOf(upisaniBroj).length();
        int brojProvjere = upisaniBroj;
        int znamenka;
        float zbroj = 0;
        for (int i = 0; i < brojZnamenki; i++) {
            znamenka = upisaniBroj % (10);
            zbroj += Math.pow(znamenka, brojZnamenki);
            upisaniBroj = (upisaniBroj - znamenka) / 10;
        }

        return zbroj == brojProvjere;
    }

}
