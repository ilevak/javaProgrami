/*
 * Ulazna linija: broj
* ispisuje piramidu sastavljenu od zvjezdica ili brojeva, pri cemo se razlikuju piramide raspisane po brojevima (uzlazno kreirana, silazno,
* u svakom retku je redni broj retka, u svakom retku se brojevi povecavaju od 1 do 9 ili u svakom retku su brojevi od 1 do 9 pa opet od 9 do 1)
 */

/**
 *
 * @author ivale
 */
public class Piramid {

    /**
     * @param args the command line arguments
     */
    static int numbRows = 0;

    public static void main(String[] args) {
        if (args.length == 1) {
            numbRows = Integer.parseInt(args[0]);
            makePiramidStarsDownward();
            if (numbRows < 10) {
                makePiramidNumbDownward();
                makePiramidNumbUpward();
                makePiramidNumbLeftRight();
                makePiramidNumbCenterUpDownward();
                makePiramidNumbCenterUpUpwards();
            }
        }
    }

    private static void makePiramidStarsDownward() {
        int numberOfSpaces;
        String piramid = "";
        for (int i = 1; i <= numbRows; i++) {
            numberOfSpaces = numbRows - i;
            piramid = addSpacesBeginRow(numberOfSpaces, piramid);
            for (int j = 1; j <= i; j++) {
                piramid = piramid + "* ";
            }
            piramid = piramid + "\n";
        }
        System.out.println(piramid);
    }

    private static void makePiramidNumbDownward() {
        String piramid = "";
        for (int i = 1; i <= numbRows; i++) {
            piramid = makePiramidNorm(i, piramid);
        }
        System.out.println(piramid);
    }

    private static void makePiramidNumbUpward() {
        String piramid = "";
        for (int i = numbRows; i > 0; i--) {
            piramid = makePiramidNorm(i, piramid);
        }
        System.out.println(piramid);
    }

    private static void makePiramidNumbLeftRight() {
        int numberOfSpaces;
        String piramid = "";
        for (int i = 1; i <= numbRows; i++) {
            numberOfSpaces = numbRows - i;
            piramid = addSpacesBeginRow(numberOfSpaces, piramid);
            for (int j = 1; j <= i; j++) {
                piramid = piramid + j + " ";
            }
            piramid = piramid + "\n";
        }
        System.out.println(piramid);
    }

    private static void makePiramidNumbCenterUpDownward() {
        String piramid = "";
        for (int i = 1; i <= numbRows; i++) {
            piramid = makePiramideCenter(i, piramid);
        }
        System.out.println(piramid);
    }

    private static void makePiramidNumbCenterUpUpwards() {
        String piramid = "";
        for (int i = numbRows; i > 0; i--) {
            makePiramideCenter(i, piramid);
        }
        System.out.println(piramid);
    }

    private static String makePiramideCenter(int i, String piramid) {
        int numberOfSpaces;
        numberOfSpaces = (numbRows - i) * 2;
        piramid = addSpacesBeginRow(numberOfSpaces, piramid);
        for (int j = 1; j <= i; j++) {
            piramid = piramid + j + " ";
        }
        for (int j = i - 1; j > 0; j--) {
            piramid = piramid + j + " ";
        }
        piramid = piramid + "\n";
        return piramid;
    }

    private static String makePiramidNorm(int i, String piramid) {
        int numberOfSpaces;
        numberOfSpaces = numbRows - i;
        piramid = addSpacesBeginRow(numberOfSpaces, piramid);
        for (int j = 1; j <= i; j++) {
            piramid = piramid + i + " ";
        }
        piramid = piramid + "\n";
        return piramid;
    }

    private static String addSpacesBeginRow(int numberOfSpaces, String piramid) {
        for (int j = 1; j <= numberOfSpaces; j++) {
            piramid = piramid + " ";
        }
        return piramid;
    }

}
