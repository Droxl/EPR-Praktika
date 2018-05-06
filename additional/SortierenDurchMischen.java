/**
 * Sortieren durch Mischen.
 * @author ich
 */
public class SortierenDurchMischen {
    /**
     * Liefert die Verschmelzung zweier Zahlen Anzahl Ziffern einer Zahl.
     * @param linkeHaelfte Linke Haelfte der uebergebenen Zahl.
     * @param rechteHaelfte Rechte Haelfte der uebergebenen Zahl.
     * @return Verschmelzt zwei Zahlen, wobei die groessere nach vorne
     * "gemischt" wird.
     */
    private static long mische(long linkeHaelfte, long rechteHaelfte) {
        return linkeHaelfte == 0
                ? rechteHaelfte
                : (rechteHaelfte == 0)
                ? linkeHaelfte
                : (linkeHaelfte % 10 > rechteHaelfte % 10)
                ? mische(linkeHaelfte / 10, rechteHaelfte) * 10 
                + linkeHaelfte % 10
                : mische(linkeHaelfte, rechteHaelfte / 10) * 10 
                + rechteHaelfte % 10;
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
        long teiler = (long) Math.pow(10, gibLaenge(zahl) / 2);
        long linkeHaelfte = zahl / teiler;
        long rechteHaelfte = zahl % teiler;
        return zahl < 10
                ? zahl
                : mische(sortiere(linkeHaelfte), sortiere(rechteHaelfte));
    }
    /**
     * Hauptmethode zur Ueberprufung auf Korrektheit, der obigen Methoden und
     * zur Ausgabe auf dem Bildschirm.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        System.out.println("------------------------------------------------");
        System.out.println(sortiere(1));
        System.out.println(sortiere(5001));
        System.out.println(sortiere(13542));
        System.out.println(sortiere(504030209));
        System.out.println("------------------------------------------------");
    }
}
