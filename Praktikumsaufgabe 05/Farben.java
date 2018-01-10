/**
 * Diese Klasse enthält zwei statische Methoden zum Umgang mit 
 * einem additiven Farbmodell. 
 * Die Repräsentation der Farben basiert auf dem Farbmodell RGB, 
 * 256 stellt dabei die Basis dar.
 * @author Droxl
 */
public class Farben {
    /**
     * Liefert zur gegebenen Farbe die invertierte Farbe.
     * @param farbe Übergabe-Parameter für die Farbe.
     * @return Gibt die invertierte Farbe zurück.
     */
    public static int invertiere(int farbe) {
        return 255255255 - farbe;
    }
    /**
     * Liefert zur gegebenen Farbe die nächste Farbe.
     * @param farbe Übergabe-Parameter für die Farbe.
     * @return Gibt die, um den Farbwert eins erhöhte, nächste Farbe zurück.
     */
    public static int gibNaechsteFarbe(int farbe) {
        //Variable für den Rotanteil der Farbe.
        int rotanteil;
        //Variable für den Grünanteil der Farbe.
        int gruenanteil;
        //Variable für den Blauanteil der Farbe.
        int blauanteil;
        //Variable für den entstehenden Übertrag.
        int uebertrag;
        //Teilt die Farbe in einen Blauanteil...
        blauanteil = farbe % 1_000;
        //...einen Grünanteil...
        gruenanteil = farbe % 1_000_000 / 1_000;
        //...und einen Rotanteil auf.
        rotanteil = farbe / 1_000_000;
        //Nur der Blauanteil wird um den Wert 1 erhöht.
        blauanteil = blauanteil + 1;
        /*Der Übertrag errechnet sich aus dem Rest des Blauanteils, 
        dividiert durch die Basis 256.*/
        uebertrag = blauanteil / 256;
        /*Der neue Blauanteils ist der aufgrundlage 
        dieser Division entstehende Rest.*/
        blauanteil = blauanteil % 256;
        /*Der neue Grünanteil entsteht aus der Addition 
        des bisherigen Grünanteils mit dem anfallenden Übertrag.*/
        gruenanteil = gruenanteil + uebertrag;
        /*Der neue Übertrag errechnet sich aus dem Rest des Grünanteils, 
        dividiert durch die Basis 256.*/
        uebertrag = gruenanteil / 256;
        /*Der aus der Addition des bisherigen Grünanteils mit dem 
        anfallenden Übertrag entstehende neue Grünanteil, muss 
        mit der Basis 256, durch den Restweroperator dividiert werden, 
        damit er einen mathematisch präzisen Wert bekommt.*/
        gruenanteil = gruenanteil % 256;
        /*Der neue Rotanteil entsteht aus der Addition 
        des bisherigen Rotanteils mit dem anfallenden Übertrag.*/
        rotanteil = rotanteil + uebertrag;
        /*Der aus der Addition des bisherigen Rotanteils mit dem 
        anfallenden Übertrag entstehende neue Rotanteil, muss 
        mit der Basis 256, durch den Restweroperator dividiert werden, 
        damit er einen mathematisch präzisen Wert bekommt.*/
        rotanteil = rotanteil % 256;
        //Am Ende wird der Übertrag auf 0 zurück gesetzt.
        uebertrag = 0;
        /*Gibt die gesamte, aus allen drei Farbanteilen
        entstehende Farbe, zurück.*/
        return (rotanteil * 1_000_000) + (gruenanteil * 1_000) + blauanteil;
    }
    /**
     * Hauptmethode die die statischen Methoden 
     * auf korrekte Funktionalität überprüft.
     * @param args findet keine Verwendung.
     */
    public static void main(String[] args) {
        /*Gewünschtes Ergebnis: 255255255*/
        System.out.println(invertiere(0));
        /*Gewünschtes Ergebnis: 245127000*/
        System.out.println(invertiere(10128255));
        /*Gewünschtes Ergebnis: 010011013*/
        System.out.println(gibNaechsteFarbe(10011012));
        /*Gewünschtes Ergebnis: 010129000*/
        System.out.println(gibNaechsteFarbe(10128255));
        /*Gewünschtes Ergebnis: 001000000*/
        System.out.println(gibNaechsteFarbe(255255));
        /*Gewünschtes Ergebnis: 0*/
        System.out.println(gibNaechsteFarbe(255255255));
    }
}
