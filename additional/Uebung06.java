public class Uebung06 {
    /**
     * Liefert die Anzahl Ziffern einer Zahl.
     * @param links Linke Seite der uebergebenen Zahl.
     * @param rechts Rechte Seite der uebergebenen Zahl.
     * @return Verschmelzt zwei Zahlen, wobei die groessere nach vorne
     * "gemischt" wird.
     */
    private static long mische(long links, long rechts) {
        return links == 0
                ? rechts
                : (rechts == 0)
                ? links
                : (links % 10 < rechts % 10)
                ? mische(links / 10, rechts) * 10 + links % 10
                : mische(links, rechts / 10) * 10 + rechts % 10;
    }
    /**
     * Liefert die Anzahl Ziffern einer Zahl.
     * @param zahl Die uebergebene Zahl mit der operiert wird.
     * @return Gibt die Anzahl der Ziffern dieser Zahl.
     */
    private static int gibLaenge(long zahl) {
        return zahl < 10
                ? 1
                : gibLaenge(zahl / 10) + 1;
    }
    /**
     * Sortiert die eingegebene Zahl und liefert sie in geordneter
     * Reihenfolge zurueck.
     * @param zahl Die uebergebene Zahl auf der operiert wird.
     * @return Gibt die geordnete Zahl zurueck.
     */
    public static long sortiere(long zahl) {
        int laenge = gibLaenge(zahl);
        long teiler = (long) Math.pow(10, laenge / 2);
        long links = zahl / teiler;
        long rechts = zahl % teiler;
        return zahl < 10
                ? zahl
                : mische(sortiere(links), sortiere(rechts));
    }
    /**
     * Diese Hilfs-Methode dreht eine gegebene Zahl um und gibt
     * das Ergebnis zurueck.
     * @param zahl Die eingegebene Zahl mit der gearbeitet wird.
     * @param drehung Hiermit wird gedreht.
     * @return Gibt die umgedrehte Zahl zurueck.
     */
    private static long umDreher(long zahl, long drehung) {
        return zahl < 10
                ? zahl + drehung * 10
                : umDreher(zahl / 10, zahl % 10 + (drehung * 10));
    }
    /**
     * Diese Methode dreht eine gegebene Zahl, mithilfe der Methode "umDreher"
     * um und gibt das Ergebnis zurueck.
     * @param zahl Die eingegebene Zahl mit der gearbeitet wird.
     * @return Gibt die umgedrehte Zahl zurueck.
     */
    public static long dreheUm(long zahl) {
        long umGedreht = umDreher(zahl, 0);
        return umGedreht;
    }
    /**
     * Hauptmethode zur Ueberprufung auf Korrektheit, der obigen Methoden und
     * zur Ausgabe auf dem Bildschirm.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        System.out.println(dreheUm(sortiere(1)));
        System.out.println(dreheUm(sortiere(5001)));
        System.out.println(dreheUm(sortiere(13542)));
        System.out.println(dreheUm(sortiere(504030209)));
        System.out.println("------------------------------------------------");
    }
}
