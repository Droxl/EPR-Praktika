/**
 * Klasse zur Addition zweier natürlicher Zahlen (einschließlich 0), die in 
 * einem Stellenwertsystem zu einer gegebenen Basis zwischen 2 und 10 
 * dargestellt sind. 
 * Die Summe wird in der gleichen Darstellung der Übergabe zurückgegeben.
 * @author Droxl
 */
public class Zahldarstellung {
    /**
     * Methode die zu einer Zahldarstellung und 
     * einer Basis den zugehörigen Wert liefert.
     * @param zahl Übergabeparameter der Zahl, mit der gearbeteitet wird.
     * @param basis Basis für das Stellenwertsystem.
     * @return Gibt den Wert der Basisdarstellung einer Zahl wieder.
     */
    public static long gibBasisWert(long zahl, int basis) {
        //Ist die Zahl kleiner als die Basis...
        return (zahl < basis)
                //...wird nur die Zahl zurückgegeben.
                ? zahl
                /*Ist sie merhstellig, werden die einzelnen Stellen 
                rekursiv durchlaufen, und mit der Basis multipliziert.
                Dadruch ensteht die jeweils gültige Gesamtsumme dieser Zahl, 
                im angegebenen Stellwertsystem.*/
                : zahl % 10 + gibBasisWert(zahl / 10, basis) * basis;
    }
    /**
     * Methode die zu einer Zahl die Darstellung 
     * in einem Stellenwertsystem einer bestimmten Basis liefert.
     * @param zahl Eingabezahl dessen Darstellung 
     * im Stellenwertsystem ermittelt wird.
     * @param basis Basis des Stellenwertsystems in dem die Zahl 
     * dargestellt werden soll.
     * @return Darstellung einer Zahl im angegebenen Stellenwertsystem.
     */
    public static long liefereDarstellungStellenwert(long zahl, int basis) {
        /*Ergibt die Gesamtzahl, durch die Basis dividiert 0,...*/
        return (zahl / basis == 0)
                /*...so endet der Alogrithmus zur Bestimmung der Zahl 
                in diesem Stellenwertsystem (Trivialfall).*/
                ? zahl
                /*Bis dahin muss die Zahl fortlaufend durch die Basis dividiert 
                werden und mit 10 multipliziert werden, damit sie nicht 
                verfälscht wird. 
                Der Rest, der entsteht wird aufsummiert. 
                Somit erhält man die korrekte Darstellung dieser Zahl 
                im Stellenwertsystem zur jeweiligen Basis.*/
                : liefereDarstellungStellenwert(zahl / basis, basis) * 10 + (
                zahl % basis);
    }
    /**
     * Methode die überprüft ob die einzelnen Ziffern einer Zahl 
     * im Stellenwertsystem einer bestimmten Basis gültig sind.
     * @param zahl Eingegebene Zahl, die auf Gültigkeit überprüft wird.
     * @param basis Basis des Stellenwertsystems.
     * @return Prüfung auf Korrektheit hinsichtlich des Basisstellenwertsystems.
     */
    public static boolean istGueltig(long zahl, int basis) {
        //Überprüfung auf Trivialfall (einstellige Zahl).
        return (zahl < 10)
                /*Überprüfung einzelner Ziffer.*/
                ? (zahl < basis)
                /*Überprüfung, ob die einzelnen Ziffern einer mehrstelligen 
                Zahl, ebenfalls gültig, also kleiner als die Basis sind. 
                Dabei wird die übergebene Zahl rekursiv durchlaufen.*/
                : istGueltig(zahl / 10, basis) && ((zahl % 10) < basis);
    }
    /**
     * Methode zur Addition zweier gültiger Zahlen, in 
     * einem Stellenwertsystem, einer bestimmten Basis.
     * @param zahl1 Erster Summand der Eingabe.
     * @param zahl2 Zweiter Summand der Eingabe.
     * @param basis Basis zu der Zahlen dargestellt werden.
     * @return Darstellung einer Zahl im angegebenen Stellenwertsystem.
     */
    public static long addiere(long zahl1, long zahl2, int basis) {
        /*Überprüft, ob die erste übergebene Zahl zur Basis korrekt 
        im Stellenwertsystem ist.*/
        boolean gueltigeZahl1 = istGueltig(zahl1, basis);
        /*Überprüft, ob die zweite übergebene Zahl zur Basis korrekt 
        im Stellenwertsystem ist.*/
        boolean gueltigeZahl2 = istGueltig(zahl2, basis);
        /*Konvertiert die erste Zahl ins Dezimalwertsystem.*/
        long konvertierteZahl1 = gibBasisWert(zahl1, basis);
        /*Konvertiert die zweite Zahl ins Dezimalwertsystem.*/
        long konvertierteZahl2 = gibBasisWert(zahl2, basis);
        /*Addiert die Werte beider Zahlen im Dezimalwertsystem.*/
        long dezimalErgebnis = konvertierteZahl1 + konvertierteZahl2;
        /*Konvertiert das Ergebnis ins Stellenwertsystem 
        der angegebenen Basis...*/
        long endErgebnis = liefereDarstellungStellenwert(
                dezimalErgebnis, basis);
        /*...und gibt es dann aus. 
        Sind beide Zahlen im jeweiligen Zahlensystem, 
        zur gegebenen Basis gültig...*/
        return (gueltigeZahl1 && gueltigeZahl2)
                /*...so ist auch das Ergebnis gültig.*/
                ? endErgebnis
                //Im anderen Fall wird eine "-1" zurückgegeben.
                : -1;
    }
    /**
     * Diese Methode prüft die obigen Methoden auf Korrektheit 
     * in der Ausführung.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        // 1001 11 2 Sollergebnis: 1100
        System.out.println(addiere(1001, 11, 2));
        // 11011 1110 2 Sollergebnis: 101001
        System.out.println(addiere(11011, 1110, 2));
        // 210 11 2 Sollergebnis: -1
        System.out.println(addiere(210, 11, 2));
        // 773 0 8 Sollergebnis: 773
        System.out.println(addiere(773, 0, 8));
        // 0 107 8 Sollergebnis: 107
        System.out.println(addiere(0, 107, 8));
        // 773 107 8 Sollergebnis: 1102
        System.out.println(addiere(773, 107, 8));
        // 773 1239 8 Sollergebnis: -1
        System.out.println(addiere(773, 1239, 8));
        // 950 192 8 Sollergebnis: -1
        System.out.println(addiere(950, 192, 8));
        // 9145 882 10 Sollergebnis: 10027
        System.out.println(addiere(9145, 882, 10));
        // 11111111111L 1 2 Sollergebnis: 100000000000
        System.out.println(addiere(11111111111L, 1, 2));
        // 323 133 4 Sollergebnis: 1122
        System.out.println(addiere(323, 133, 4));
    }
}