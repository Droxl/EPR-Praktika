/**
 * Klasse zum Testen der "RationaleZahl"-Objekte.
 * @author Droxl
 */
public class RationaleZahlTest {
    /**
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        RationaleZahl r1;
        RationaleZahl r2;
        System.out.println("-----------------Aufgabe 1: ----------------");
        /**
         * 1. Objekt 2/8 erzeugen, also ein Objekt der Klasse RationaleZahl 
         * mit Zaehler 2 und Nenner 8.
         */
        System.out.println(r1 = new RationaleZahl(2, 8));
        System.out.println("-----------------Aufgabe 2: ----------------");
        /**
         * 2. textuelle Darstellung des Objekts aus Schritt 1 auf dem
         * Bildschirm ausgeben. Sollergebnis: 1/4.
         */
        System.out.println(r1.gibAlsText());
        System.out.println("-----------------Aufgabe 3: ----------------");
        /**
         * 3. Objekt 5/6 erzeugen.
         */
        System.out.println(r2 = new RationaleZahl(5, 6));
        System.out.println("-----------------Aufgabe 4: ----------------");
        /**
         * 4. addiere-Methode für Objekt aus Schritt 1 mit Objekt 
         * aus Schritt 3 als Parameter aufrufen und Ergeb-
         * nis der Methode textuell auf dem Bildschirm ausge-
         * ben. Sollergebnis: 13/12.
         */
        System.out.println(r1.addiere(r2).gibAlsText());
        System.out.println("-----------------Aufgabe 5: ----------------");
        /**
         * 5. addiere-Methode für Objekt aus Schritt 3 mit Ob-
         * jekt aus Schritt 1 als Parameter aufrufen und Ergeb-
         * nis der Methode textuell auf dem Bildschirm ausge-
         * ben. Sollergebnis: 13/12.
         */
        System.out.println(r2.addiere(r1).gibAlsText());
        System.out.println("-----------------Aufgabe 6: ----------------");
        /**
         * 6. addiere-Methode für 17/4 mit 7/4 als Parameter aufrufen und Ergeb-
         * nis der Methode textuell auf dem Bildschirm ausgeben.
         * Sollergebnis: 6
         */
        System.out.println(new RationaleZahl(17, 4).addiere(
                new RationaleZahl(7, 4)).gibAlsText());
        System.out.println("-----------------Aufgabe 7: ----------------");
        /**
         * 7. addiere-Methode für 100002/4 mit rationaler Zahl 5 als Parameter 
         * ausfuehren und Ergebnis der Methode textuell auf dem Bildschirm 
         * ausgeben. 
         * Sollergebnis: 50011/2
         */
        System.out.println(new RationaleZahl(100002, 4).addiere(
                new RationaleZahl(5)).gibAlsText());
        System.out.println("-----------------Aufgabe 8: ----------------");
        /**
         * 8. addiere-Methode für 11/2108303 mit 31/2117009 als Parameter 
         * ausfuehren, zum Ergebnis 47/2134421 addieren und dieses Ergebnis 
         * textuell auf dem Bildschirm ausgeben.
         * Sollergebnis: 189502901/4524816707267
         */
        System.out.println((new RationaleZahl(11, 2108303).addiere(
                new RationaleZahl(31, 2117009)).addiere(
                        new RationaleZahl(47, 2134421))).gibAlsText());
        System.out.println("-----------------Aufgabe 9: ----------------");
        /**
         * 9. addiere-Methode für 3/3037000510 mit rationaler Zahl 7/3037000500 
         * als Parameter ausfuehren und Ergebnis der Methode 
         * textuell auf dem Bildschirm ausgeben.
         * Sollergebnis: 3037000507/922337206737025500
         */
        System.out.println(new RationaleZahl(3L, 3037000510L).addiere(
                new RationaleZahl(7L, 3037000500L)).gibAlsText());
    }
}