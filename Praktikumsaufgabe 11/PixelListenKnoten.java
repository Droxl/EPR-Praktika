/**
 * Diese Klasse stellt einen einzelnen Pixel als Knoten innerhalb einer 
 * rekursiven Listenstruktur dar.
 * @author Droxl
 */
public class PixelListenKnoten {
    /**
     * Wert des Knotens an dieser Position.
     */
    private Punkt farbWert;
    /**
     * Oberelement.
     */
    private PixelListenKnoten oberKnoten;
    /**
     * Folgeelement.
     */
    private PixelListenKnoten naechsterKnoten;
    /**
     * Erstelt ein Element ohne Oberelement- und ohne Folgeelement.
     * @param farbWert Der Farbwert.
     */
    public PixelListenKnoten(Punkt farbWert) {
        this.farbWert = farbWert;
        this.oberKnoten = null;
        this.naechsterKnoten = null;
    }
    /**
     * Erstelt ein Element mit Ober- aber ohne Folgeelement.
     * @param farbWert Der Farbwert.
     * @param oberKnoten Oberelement.
     */
    public PixelListenKnoten(Punkt farbWert, PixelListenKnoten oberKnoten) {
        this.farbWert = farbWert;
        this.oberKnoten = oberKnoten;
    }
    /**
     * Erstelt ein Element mit Ober- und Folgeelement.
     * @param farbWert Der Farbwert.
     * @param oberKnoten Oberelement.
     * @param naechsterKnoten Folgeelement.
     */
    public PixelListenKnoten(Punkt farbWert,
            PixelListenKnoten oberKnoten,
            PixelListenKnoten naechsterKnoten) {
        this.farbWert = farbWert;
        this.oberKnoten = oberKnoten;
        this.naechsterKnoten = naechsterKnoten;
    }
    /**
     * Gibt das Folgeelement zurück.
     * @return Das Folgeelement.
     */
    public PixelListenKnoten liefereNaechstenKnoten() {
        return naechsterKnoten;
    }
    /**
     * Setzt das Folgeelement.
     * @param naechsterKnoten Folgeelement.
     */
    public void setzeNaechstenKnoten(PixelListenKnoten naechsterKnoten) {
        this.naechsterKnoten = naechsterKnoten;
    }
    /**
     * Gibt den allerersten Knoten zurück.
     * @return Das Oberelement.
     */
    public PixelListenKnoten gibOberKnoten() {
        return this.oberKnoten;
    }
    /**
     * Setzt den Oberknoten.
     * @param oberKnoten der Oberknoten.
     */
    public void setzeOberKnoten(PixelListenKnoten oberKnoten) {
        this.oberKnoten = oberKnoten;
    }
    /**
     * Methode die den Farbwert liefert.
     * @return Liefert den Farbwert.
     */
    public Punkt gibFarbe() {
        return this.farbWert;
    }
}