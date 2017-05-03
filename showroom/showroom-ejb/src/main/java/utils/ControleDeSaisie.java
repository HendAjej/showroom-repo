

package utils;


public class ControleDeSaisie {

    public final static int INTEGER = 0;
    public final static int STRING = 1;
    public final static int DOUBLE = 2;
    public final static int FLOAT = 3;
    public final static int LONG = 4;

    
    final static String msg_non_valide = " is invalid";
    final static String msg_vide = " is empty";
    final static String msg_long = " size can't be more than ";

    public static void nonLong(String Attribut, String contenu, int taille) throws ControleDeSaisieException {
        if (contenu.length() >= taille) {
            throw new ControleDeSaisieException(Attribut + msg_long+" "+Integer.toString(taille)+" caractères");
        }
    }

    public static void nonVide(String Attribut, String contenu) throws ControleDeSaisieException {
        if (contenu.trim().equals("")) {
            throw new ControleDeSaisieException(Attribut + msg_vide);
        }
    }

    private static boolean verifierDouble(String contenu) {
        try {
            Double d = Double.parseDouble(contenu);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static boolean verifierFloat(String contenu) {
        try {
            Float d = Float.parseFloat(contenu);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static boolean verifierInteger(String contenu) {
        try {
            Float d = Float.parseFloat(contenu);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static void verifierType(String Attribut, String contenu, int type) throws ControleDeSaisieException {
        if (type == DOUBLE) {
            if (!(verifierDouble(contenu))) {
                throw new ControleDeSaisieException(Attribut + msg_non_valide);
            }
        }

        if (type == FLOAT) {
            if (!(verifierFloat(contenu))) {
                throw new ControleDeSaisieException(Attribut + msg_non_valide);
            }
        }

        if (type == INTEGER) {
            if (!(verifierInteger(contenu))) {
                throw new ControleDeSaisieException(Attribut + msg_non_valide);
            }
        }
    }

    public static void verifier(String Attribut, String contenu, int type) throws ControleDeSaisieException {
        nonVide(Attribut, contenu);
        verifierType(Attribut, contenu, type);
    }
    
    public static void verifier(String Attribut, String contenu, int type, int taille) throws ControleDeSaisieException {
        nonVide(Attribut, contenu);
        nonLong(Attribut, contenu, taille);
        verifierType(Attribut, contenu, type);
    }
}
