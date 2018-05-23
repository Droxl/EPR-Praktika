/**
 * Ein Objekt dieser Klasse repräsentiert die Schlange des Schlange-Spiels, 
 * das mit einem anwachsenden Array realisiert ist.
 * @author Droxl
 */
public class Schlange {
    /**
     * Die Position der Schlange auf dem Spielfeld. 
     * Genauer des Kopfs der Schlange, da die Schlange zu Beginn 
     * nur aus einem Segment, nämlich dem Kopf besteht.
     */
    private Punkt[] schlange;
    /**
     * Das Feld speichert die vier möglichen Bewegungsrichtungen der Schlange.
     */
    private final Punkt[] richtungen;
    /**
     * Richtung in die sich die Schlange momentan bewegt.
     */
    private int richtungsVektor;
    /**
     * Erzeugt ein Schlange-Objekt mit nur einem Segment.
     * @param xPosition x-Position auf der Koordinatenachse.
     * @param yPosition y-Position auf der Koordinatenachse.
     */
    public Schlange(int xPosition, int yPosition) {
        /**
         * Erstes Segment der Schlange.
         */
        this.schlange = new Punkt[1];
        /**
         * Die Position setzt sich aus einem X-
         * und Y-Koordinatenabschnitt zusammen.
         */
        this.schlange[0] = new Punkt(xPosition, yPosition);
        /*Dieses Feld enthält die vier möglichen Bewegunsrichtungen
        der Schlange.*/
        richtungen = new Punkt[4];
        /*Da der Richtungsvektor mit % 4 berechnet wird, 
        kann sich die Schlange nur in die vorgegebenen Richtungen bewegen.*/
        //Bewegungsänderung nach oben.
        richtungen[0] = new Punkt(0, -1);
        //Bewegungsänderung nach rechts.
        richtungen[1] = new Punkt(1, 0);
        //Bewegungsänderung nach unten.
        richtungen[2] = new Punkt(0, 1);
        //Bewegungsänderung nach links.
        richtungen[3] = new Punkt(-1, 0);
        //Anfänglich bewegt sich die Schlange auf dem Spielfeld nach rechts.
        richtungsVektor = 1;
    }
    /**
     * Ändert die aktuelle Bewegungsrichtung der Schlange 
     * um 90 Grad im Uhrzeigersinn. 
     * Durch diese Methode geht die Schlange nicht voran, 
     * es ändert sich lediglich die Bewegungsrichtung. 
     * Die zweimalige Anwendung dieser Methode 
     * direkt hintereinander bewirkt die Umkehrung der ursprünglichen 
     * Bewegungsrichtung, wodurch es bei anschließendem 
     * Aufruf von geheVoran zu einer Kollision kommt.
     */
    public void dreheRechts() {
        //Dreht immer nach rechts.
        this.richtungsVektor = (this.richtungsVektor + 1) % 4;
    }
    /**
     * Ändert die aktuelle Bewegungsrichtung der Schlange 
     * um 90 Grad gegen den Uhrzeigersinn. 
     * Durch diese Methode geht die Schlange nicht voran, 
     * es ändert sich lediglich die Bewegungsrichtung. 
     * Die zweimalige Anwendung dieser Methode 
     * direkt hintereinander bewirkt die Umkehrung der ursprünglichen 
     * Bewegungsrichtung, wodurch es bei anschließendem 
     * Aufruf von geheVoran zu einer Kollision kommt.
     */
    public void dreheLinks() {
        //Dreht immer nach links.
        this.richtungsVektor = (this.richtungsVektor + 3) % 4;
    }
    /**
     * Hierdurch geht die Schlange in ihrer aktuellen Bewegungsrichtung 
     * um ein Feld vor.
     * @param futter Der Parameter gibt die Position des Futters an.
     * @return Schlange geht erfolgreich voran oder nicht.
     */
    public boolean geheVoran(Punkt futter) {
        /*Durch das Futter neu entstandener Kopf.*/
        Punkt neuerKopf = schlange[0].addiere(richtungen[richtungsVektor]);
        /*Liefert einen Wahrheitswert abhängig davon, 
        ob die Schlange nicht kollidert. 
        Ist das Vorangehen nicht erfolgreich, wird das Spiel beendet.*/
        boolean gehenErfolgreich = true;
        //Frisst die Schlange...
        if (futter.istGleich(neuerKopf)) {
            /*Schlange verlängern!
            Internes Array zur Verwaltung der Schlangensegmente. 
            Die Schlange wächst um genau 1 Segment.*/
            Punkt[] neueSchlange = new Punkt[schlange.length + 1];
            //Der neuen Schlange werden die alten Elemente übergeben.
            for (int i = 0; i < schlange.length; i++) {
                neueSchlange[i + 1] = schlange[i];
            }
            //Der neue Schlangenkopf bekommt die Attribute des alten zugewiesen.
            neueSchlange[0] = schlange[0].addiere(richtungen[richtungsVektor]);
            //Neue Referenz der Schlange auf ihre gewachsenen Segmente.
            this.schlange = neueSchlange;
            
            //...oder nicht.
        } else {
            //Nur wenn Schlangenteile nicht kollidieren geht die Schlange voran.
            for (int i = 0; i < schlange.length - 1; i = i + 1) {
                if (schlange[i].istGleich(neuerKopf)) {
                    gehenErfolgreich = false;
                }
            }
            /*
            Bewegt die Schlange.
            Internes Array zur Verwaltung der Schlangensegmente.
            Die Schlange bewegt sich um 1 Feld vorwärts,
            wobei sie nicht wächst.
            */
            Punkt[] neueSchlange = new Punkt[schlange.length];
            //Der neuen Schlange werden die alten Elemente übergeben.
            for (int i = 0; i < schlange.length - 1; i++) {
                neueSchlange[i + 1] = schlange[i];
            }
            //Der neue Schlangenkopf bekommt die Attribute des alten zugewiesen.
            neueSchlange[0] = schlange[0].addiere(richtungen[richtungsVektor]);
            //Die Schlange verweist auf die neue Position der Schlange.
            this.schlange = neueSchlange;
        }
        //Geht erfogreich voran, wenn keine Kollision vorliegt.
        return gehenErfolgreich;
    }
    /**
     * Liefert die Länge der Schlange.
     * @return Gibt die Länge der Schlange wieder.
     */
    public int gibLaenge() {
        return schlange.length;
    }
    /**
     * Diese Methode liefert die Position eines Schlangensegments.
     * Die Nummerierung der Segmente beginnt bei 0 (für den Kopf der Schlange).
     * Das Segment 1 ist das erste hinter dem Kopf usw.
     * @param index Der Index zur Segmentaddressierung.
     * @return Liefert das Segment an der Stelle des übergebenen Indexes.
     */
    public Punkt gibSegment(int index) {
        return this.schlange[index];
    }
    /**
     * Liefert genau dann true, wenn auf der angegebenen Position 
     * ein Segment der Schlange liegt.
     * @param segmentposition Dient der Überprüfung, ob auf der angegebenen 
     * Position ein Segment der Schlange liegt.
     * @return Boolescher Wert, der sich auf das Segment bezieht.
     */
    public boolean enthaeltPunkt(Punkt segmentposition) {
        /*Solange kein Segment an der Position liegt, 
        kann sich die Schlange vorwärts bewegen.*/
        boolean segmentLiegtAnPosition = false;
        /*Eine erweiterte "for()-Schleife", die über alle 
        "Felder der Schlange" (Segmente) iteriert.*/
        for (Punkt segment : schlange) {
            //Stimmt die Position überein...
            if (segmentposition.istGleich(segment)) {
                //...kann die Schlange nicht weitergehen.
                segmentLiegtAnPosition = true;
            }
        }
        /*Wahrheitswert in deren Abhängigkeit das Spiel 
        forgesetzt oder beendet wird.*/
        return segmentLiegtAnPosition;
    }
}
