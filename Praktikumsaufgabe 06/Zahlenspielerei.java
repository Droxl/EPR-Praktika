/**
 * Rekursiv definierte Methoden zum Überprüfen, ob eine Ziffer in der
 * Darstellung einer Zahl enthalten ist, wie oft sie enthalten ist
 * und eine Methode zum Rausstreichen dieser Ziffer innerhalb einer
 * Zahlendarstellung.
 * @author Droxl
 */
public class Zahlenspielerei {
    /**
     * Diese Methode überprüft, ob eine gegebene Ziffer innerhalb einer
     * gegebenen Zahlendarstellung vorkommt.
     * @param zahl Gegebene Zahl, die untersucht wird.
     * @param ziffer Gegebene Ziffer, mit der untersucht wird.
     * @return boolean Gibt an, ob die Ziffer in der Zahl steckt,
     * oder nicht.
     */
    public static boolean enthaelt(long zahl, int ziffer) {
        return (zahl < 10 || (zahl % 10) == ziffer)
                ? ((zahl % 10) == ziffer)
                : enthaelt(zahl / 10, ziffer);
    }
    /**
     * Diese Methode überprüft, wie oft eine gegebene Ziffer innerhalb einer
     * gegebenen Zahlendarstellung vorkommt.
     * @param zahl Gegebene Zahl, die untersucht wird.
     * @param ziffer Gegebene Ziffer, mit der untersucht wird.
     * @return int Anzahl der Häufigkeit dieser Ziffer innerhalb der
     * gegebenen Zahl.
     */
    public static int gibAnzahl(long zahl, int ziffer) {
        return (zahl == 0 && ziffer == 0)
                ? 1
                : zahl % 10 == ziffer
                ? 1 + gibAnzahl((zahl / 10), ziffer)
                : (zahl / 10) != 0
                ? gibAnzahl((zahl / 10), ziffer)
                : 0;
    }
    /**
     * Diese Methode streicht die übergebene Ziffer innerhalb einer
     * übergebenen Zahl.
     * @param zahl Gegebene Zahl, die untersucht wird.
     * @param ziffer Gegebene Ziffer, mit der untersucht wird.
     * @return long Streicht diese Ziffer innerhalb der Zahl,
     * wenn sie vorkommt und gibt die restliche Zahl 
     * ohne die gegebene Ziffer zurück.
     */
    public static long filter(long zahl, int ziffer) {
        return (zahl == 0)
                ? 0
                : (zahl % 10) != ziffer
                /*Streichen der Ziffer*/
                ? filter(zahl / 10, ziffer) * 10 + (zahl % 10)
                : filter(zahl / 10, ziffer);
    }
    /**
     * Die Hauptmethode testet die obigen Methoden auf Funktionalität.
     * @param args findet keine Verwendung.
     */
    public static void main(String[] args) {
        //Sollergebnis true
        System.out.println(enthaelt(4711, 1));
        //Sollergebnis false
        System.out.println(enthaelt(4711, 2));
        //Sollergebnis true
        System.out.println(enthaelt(789, 9));
        //Sollergebnis true
        System.out.println(enthaelt(0, 0));
        //Kommt zweimal vor.
        System.out.println(gibAnzahl(4711, 1));
        //Kommt kein einziges Mal vor.
        System.out.println(gibAnzahl(4711, 2));
        //Kommt einmal vor.
        System.out.println(gibAnzahl(789, 9));
        //Kommt einmal vor.
        System.out.println(gibAnzahl(0, 0));
        //Sollergebnis 12
        System.out.println(filter(1332, 3));
        //Sollergebnis 0
        System.out.println(filter(3333, 3));
        //Sollergebnis 1332
        System.out.println(filter(1332, 4));
        //Sollergebnis 1
        System.out.println(filter(1000, 0));
        //Sollergebnis 0
        System.out.println(filter(1, 1));
        //Sollergebnis 0
        System.out.println(filter(0, 0));
        //Sollergebnis 0
        System.out.println(filter(0, 5));
    }
}