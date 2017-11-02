/**
 * Diese Klasse ist für das Rasterbild notwendig, 
 * da in ihr die einzelnen Knoten, die mit Farbe befüllt werden, 
 * enthalten sind.
 * @author Droxl
 */
public class PixelListe {
    /**
     * Erstes Element der Liste.
     */
    private PixelListenKnoten ersterKnoten;
    /**
     * Letztes Element.
     */
    private PixelListenKnoten letzterKnoten;
    /**
     * Anzahl der Elemente.
     */
    private int laenge;
    /**
     * Erstellt eine Liste mit Farbwerten.
     */
    public PixelListe() {
        ersterKnoten = null;
        letzterKnoten = null;
        laenge = 0;
    }
    /**
     * Fügt ein Element der Liste hinzu.
     * @param farbElement Farbelement.
     */
    public void fuegeElementListeHinzu(Punkt farbElement) {
        if (ersterKnoten == null) {
            ersterKnoten = new PixelListenKnoten(farbElement);
            letzterKnoten = ersterKnoten;
        } else {
            letzterKnoten.setzeNaechstenKnoten(
                    new PixelListenKnoten(farbElement, letzterKnoten));
            letzterKnoten = letzterKnoten.liefereNaechstenKnoten();
        }
        laenge = laenge + 1;
    }
    /**
     * Liefert das Element am betreffenden Index zurück.
     * @param pos Position des Elements innerhalb der Liste.
     * @return Wert des Elements.
     */
    public PixelListenKnoten liefereKnotenAnPosition(int pos) {
        PixelListenKnoten knoten;
        if (pos < laenge) {
            knoten = ersterKnoten;
            int i = 0;
            while (i < pos) {
                knoten = knoten.liefereNaechstenKnoten();
            }
            i++;
        } else {
            knoten = letzterKnoten;
            int i = 0;
            while (i < laenge - pos) {
                knoten = knoten.gibOberKnoten();
            }
            i++;
        }
        return knoten;
    }
}