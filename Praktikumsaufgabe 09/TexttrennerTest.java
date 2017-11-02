/**
 * Testklasse des Texttrenners, die ihn auf korrekte Funktionalität 
 * überprüft.
 * @author Droxl
 */
public class TexttrennerTest {
    /**
     * Führt die Testmethoden aus und stellt die Testergebnisse auf
     * dem Bildschirm dar.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        System.out.println("--------------" + '\t'
                + "Test fuer Texttrenner 1 --------------");
        /*1. Texttrenner für Zeichenkette "--xx+-yy--abc--"
        und Trennzeichen "+-" erzeugen.*/
        Texttrenner t1 = new Texttrenner("--xx+-yy--abc--", "+-");
        /*2. Auf dieses Objekt die Methode hatNochWoerter anwenden.
        Soll: true.*/
        System.out.println("Soll: true, Ist: " + t1.hatNochWoerter());
        /*3. Auf dieses Objekt die Methode hatNochWoerter anwenden.
        Soll: true.*/
        System.out.println("Soll: true, Ist: " + t1.hatNochWoerter());
        /*4. Auf dieses Objekt die Methode gibNaechstesWort anwenden.
        Soll: "xx".*/
        System.out.println("Soll: xx, Ist: " + t1.gibNaechstesWort());
        /*5. Auf dieses Objekt die Methode hatNochWoerter anwenden.
        Soll: true.*/
        System.out.println("Soll: true, Ist: " + t1.hatNochWoerter());
        /*6. Auf dieses Objekt die Methode hatNochWoerter anwenden.
        Soll: true.*/
        System.out.println("Soll: true, Ist: " + t1.hatNochWoerter());
        /*7. Auf dieses Objekt die Methode gibNaechstesWort anwenden.
        Soll: "yy".*/
        System.out.println("Soll: yy, Ist: " + t1.gibNaechstesWort());
        /*8. Auf dieses Objekt die Methode gibNaechstesWort anwenden.
        Soll: "abc".*/
        System.out.println("Soll: abc, Ist: " + t1.gibNaechstesWort());
        /*9. Auf dieses Objekt die Methode hatNochWoerter anwenden.
        Soll: false.*/
        System.out.println("Soll: false, Ist: " + t1.hatNochWoerter());
        /*10. Auf dieses Objekt die Methode hatNochWoerter anwenden.
        Soll: false.*/
        System.out.println("Soll: false, Ist: " + t1.hatNochWoerter());
        /*11. Auf dieses Objekt die Methode gibNaechstesWort anwenden.
        Soll: null.*/
        System.out.println("Soll: null, Ist: " + t1.gibNaechstesWort());
    }
}