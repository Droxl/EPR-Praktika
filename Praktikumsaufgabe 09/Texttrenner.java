/**
 * Der Texttrenner erlaubt es einer Anwendung, eine Zeichenkette in 
 * Teilzeichenketten (Wörter genannt), aufzuteilen.
 * <p>
 * Die Menge der Trennzeichen (Zeichen die die Wörter aufteilen), müssen 
 * bei der Initialisierung festgelegt werden.
 * <p>
 * Ein <tt>Texttrenner</tt> -Objekt 
 * unterhält intern eine momentane Position innerhalb der Zeichenkette, 
 * die in Wörter unterteilt wird. 
 * Einige Operationen erhöhen die momentane Position über die Zeichen.
 * </p>
 * 
 * Ein Wort wird dadurch wiedergegeben, dass eine Teilkette der übergebenen 
 * Zeichenkette entnommen wird. Die erste Zeichenkette, die genutzt wurde, 
 * um das <tt>Texttrenner</tt> -Objekt zu erstellen.
 * </p>
 * Das folgende Beispiel zeigt den Gebrauch des Texttrenners. 
 * Code:
 * <blockquote><pre>
 *     Texttrenner zeichenkette = new Texttrenner("Dies ist ein Test");
 *     while (zeichenkette.hatNochWoerter()) {
 *         System.out.println(zeichenkette.gibNaechstesWort());
 *     }
 * </pre></blockquote>
 * <p>
 * Führt zu folgender Ausgabe:
 * <blockquote><pre>
 *     Dies
 *     ist
 *     ein
 *     Test
 * </pre></blockquote></p>
 * @see     java.io.StreamTokenizer
 * @since   JDK1.0
 * @see     Siehe dazu auch: http://grepcode.com/file_/repository.grepcode.com
 * /java/root/jdk/openjdk/6-b14/java/util/StringTokenizer.java/?v=source*/
/**
 * Diese Klasse trennt Wörter einer Zeichenkette, anhand einer gegebenen 
 * zweiten Zeichenkette, welche nur aus Trennzeichen besteht.
 * @author Droxl
 */
public class Texttrenner {
    /**
     * Gesamte Zeichenkette auf der operiert wird.
     */
    private final String zeichenkette;
    /**
     * Nur aus Trennzeichen bestehende Zeichenkette, mit der operiert wird.
     */
    private final String trennerkette;
    /**
     * Die jeweils aktuelle Position. 
     * Der "Pfeil" steht jeweils am Anfang des nächsten auszugebenden Wortes.
     */
    private int position;
    /**
     * Maximal mögliche Positon des Pfeils.
     */
    private final int maxPosition;
    /**
     * Erzeugt ein Texttrenner-Objekt mit einer Zeichenkette 
     * und einer Trennerkette.
     * @param zeichenkette Gesamte Zeichenkette auf der operiert wird.
     * @param trennerkette Nur aus Trennzeichen bestehende Zeichenkette, 
     * mit der operiert wird.
     */
    public Texttrenner(String zeichenkette, String trennerkette) {
        /*Übergabe des Zeichenkettenparameters zur Initialisierung.*/
        this.zeichenkette = zeichenkette;
        /*Die maixiaml mögliche Position in der Zeichenkette 
        entspricht der Gesamtlänge der Zeichenkette.*/
        maxPosition = zeichenkette.length();
        /*Übergabe des Trennzeichenkettenparameters zur Initialisierung.*/
        this.trennerkette = trennerkette;
        //Der "Pfeil" steht immer am Anfang des nächsten, auszugebenden Wortes.
        position = anfangWort();
    }
    /**
     * Diese Methode gibt an, ob das Zeichen an der aktuellen Position ein 
     * Trennzeichen ist.
     * @return Bestätigung ob Zeichen ein Trennzeichen ist, oder nicht.
     */
    private boolean istTrennzeichen() {
        //Ein Zeichen, das angibt, ob ein Trennzeichen vorliegt.
        int semaphor = 0;
        /*Indikator, ob das übergebene Zeichen tatsächlich 
        ein Trennzeichen ist.*/
        boolean istTrennzeichen = false;
        //Variable zur Bestimmung der Position des Trennzeichens.
        int trennzeichenAnPosition = 0;
        /*Eine Schleife, die die Position (also den "Pfeil"), 
        über die Zeichenkette iterieren lässt, und 
        das Trennzeichen (Trennzeichen an Position) über die Trennerkette.*/
        while (trennzeichenAnPosition < trennerkette.length() 
                && position < zeichenkette.length()) {
            /*Stimmen das Zeichen der Zeichenkette und das Trennzeichen 
            der Trennerkette überein...*/
            if (zeichenkette.charAt(position) == trennerkette.charAt(
                    trennzeichenAnPosition)) {
                /*...wird das Semaphor auf 1 gesetzt.*/
                semaphor = 1;
            }
            /*Die Position des Trennzeichens in der Trennerkette 
            wird um 1 erhöht, damit durch die Trennzeichenkette 
            gewandert werden kann und das nächste Trennzeichen dran kommt.*/
            trennzeichenAnPosition = trennzeichenAnPosition + 1;
        }
        /*Steht das Semaphor bei 1...*/
        if (semaphor == 1) {
            /*...liegt ein Trennzeichen vor...*/
            istTrennzeichen = true;
        }
        /*...und es wird wahr (true) zurückgegeben.*/
        return istTrennzeichen;
    }
    /**
     * Diese Methode liefert genau dann true, wenn der Texttrenner nach den 
     * bisher gelieferten Wörtern, noch mindestens ein weiteres Wort enthält. 
     * Sollte ein Wort vorhanden sein, so wird wahr ausgegeben, andernfalls 
     * falsch.
     * @return Gibt den Boole'schen Wert wieder <code>true</code>, 
     * wenn noch mindestens ein Wort in der ersten Zeichenkette 
     * enthalten ist, sonst <code>false</code>.
     */
    public boolean hatNochWoerter() {
        //Der Zähler zählt hoch.
        int zaehler = 0;
        /*Standardmäßig gibt es keine Wörter da der Fall, 
        dass ein Texttrenner-Objekt mit leerer Zeichenkette gebildet wird, 
        abgefangen werden muss. 
        In dem Fall soll ja bei gibNaechstesWort() "null" geliefert werden.*/
        boolean hatNochWoerter = false;
        //Das Zeichen in der Zeichenkette.
        int zeichenAnPosition = position;
        //Das Zeichen in der Trennerkette.
        int trennzeichenAnPosition;
        /*Ineinander verschachtelte Schleifen, die erste Schleife 
        läuft die gesamte Zeichenkette ab...*/
        while (zeichenAnPosition < maxPosition) {
            /*Das Trennzeichen wird auf die erste Position der 
            Trennerkette gesetzt.*/
            trennzeichenAnPosition = 0;
            /*...Die zweite Schleife, läuft die Trennerkette ab.*/
            while (trennzeichenAnPosition < trennerkette.length()) {
                /*Stimmen das Zeichen an der Position innerhalb der 
                Zeichenkette und das Trennzeichen an einer bestimmten Position 
                nicht überein, zählt der Zähler hoch...*/
                if (zeichenkette.charAt(zeichenAnPosition) 
                        != trennerkette.charAt(trennzeichenAnPosition)) {
                    zaehler = zaehler + 1;
                } else {
                    /*...Im anderen Fall steht der Zähler bei 0.*/
                    zaehler = 0;
                }
                //Das Trennzeichen wird um 1 erhöht.
                trennzeichenAnPosition = trennzeichenAnPosition + 1;
            }
            /*Ist der Wert des Zählers größer oder gleich der Länge 
            der Trennerkette, gibt es kein Trennzeichen mehr...*/
            if (zaehler >= trennerkette.length()) {
                /*...und alles was in der Zeichenkette steht, ist ein Wort.*/
                hatNochWoerter = true;
                //Das Zeichen wird auf das Ende der Zeichenkette gesetzt.
                zeichenAnPosition = zeichenkette.length() - 1;
            }
            //Das Zeichen wird um 1 erhöht.
            zeichenAnPosition = zeichenAnPosition + 1;
        }
        //Die Ausgabe erfolgt, je nach Fall mit wahr oder falsch.
        return hatNochWoerter;
    }
    /**
     * Diese Methode liefert die erste Position innerhalb der Zeichenkette, 
     * an der das Wort beginnt.
     * @return Gibt die Position an, an der das nächste Wort beginnt.
     */
    private int anfangWort() {
        /*Solange ein Trennzeichen vorliegt, es noch Wörter gibt 
        und die Position noch nicht am Ende der Zeichenkette angelangt ist,...*/
        while (istTrennzeichen() && hatNochWoerter()
                && position < maxPosition) {
            /*...wird die Position jeweils um 1 hochgezählt (inkrementiert). 
            Hiermit wird die Methode trennzeichenUeberlaeufer() eingespart.*/
            position = position + 1;
        }
        //Gibt jeweils die aktuellste Position zurück.
        return position;
    }
    /**
     * Diese Methode liefert das nächste Wort aus der zugrunde liegenden 
     * Zeichenkette. 
     * Falls die Zeichenketteke kein Wort mehr enthält, 
     * liefert die Methode null.
     * @return Liefert das nächste Wort aus der Zeichenkette.
     */
    public String gibNaechstesWort() {
        //Zu Anfang wird die Teilzeichenkette (Tokenizer), ohne Wert erstellt.
        String teilzeichenkette = "";
        //Gibt es kein zu lieferndes Wort mehr, bekommt sie den Wert "null".
        if (!hatNochWoerter()) {
            teilzeichenkette = null;
        } 
        /*Solange die Position kleiner oder gleich der Länge der Zeichenkette 
        ist und kein Trennzeichen vorkommt...*/
        while (position <= zeichenkette.length() && !istTrennzeichen()
                && position < maxPosition) {
            /*...wird das Zeichen der Position, der Teilzeichenkette 
            hinzugefügt.*/
            teilzeichenkette = teilzeichenkette + zeichenkette.charAt(position);
            //Die Position wird um 1 erhöht.
            position = position + 1;
        }
        //Der Pfeil steht auf dem ersten Zeichen des neu zu liefernden Wortes.
        position = anfangWort();
        //Gibt das nächste zu liefernde Wort aus.
        return teilzeichenkette;
    }
}