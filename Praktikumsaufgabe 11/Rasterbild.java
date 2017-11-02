/**
 * Der Farbfüller ist ein Werkzeug in Anwendungen 
 * zur Bildbearbeitung, sowie in Malprogrammen für Rastergrafiken 
 * (d.h.durch Pixel definierte Grafiken). 
 * Mit seiner Hilfe kann eine Fläche mit einer Farbe gefüllt werden. 
 * Diese Klasse füllt eine vorgegebene Fläche mit einer vorher 
 * definierten Farbe aus.
 * @author Droxl
 */
public class Rasterbild {
    /**
     * Zweidimensionale Matrix, nur aus Pixeln bestehend.
     */
    private java.awt.Color[][] pixelMatrix;
    /**
     * Höhe des Bildes in Pixeln.
     */
    private int hoehe;
    /**
     * Breite des Bildes in Pixeln.
     */
    private int breite;
    /**
     * Erstelt ein Rasterbild mit den übergebenen Farbwerten.
     * @param pixelMatrix Farbwerte als zweidimensionales Feld.
     */
    public Rasterbild(java.awt.Color[][] pixelMatrix) {
        this.pixelMatrix = pixelMatrix;
        breite = pixelMatrix.length;
        hoehe = pixelMatrix[0].length;
    }
    /**
     * Liefert die horizontale Anzahl an Pixeln des Rasterbilds.
     * @return Gibt die Breite des Bildes in Pixeln zurück.
     */
    public int gibBreite() {
        return this.breite;
    }
    /**
     * Liefert die vertikale Anzahl an Pixeln des Rasterbilds.
     * @return Gibt die Höhe des Bildes in Pixeln zurück.
     */
    public int gibHoehe() {
        return this.hoehe;
    }
    /**
     * Liefert die Farbe eines Pixels zurück.
     * @param x X-Koordinate des Pixels.
     * @param y Y-Koordinate des Pixels.
     * @return Gibt den Farbwert des Pixels als Color.
     */
    public java.awt.Color gibFarbe(int x, int y) {
        return this.pixelMatrix[x][y];
    }
    /**
     * Liefert die Farbe eines Pixels zurück.
     * @param pixel X- und Y-Koordinaten des Pixels.
     * @return Gibt den Farbwert des Pixels als Color.
     */
    public java.awt.Color gibFarbe(Punkt pixel) {
        return gibFarbe(pixel.gibX(), pixel.gibY());
    }
    /**
     * Setzt die Farbe eines Pixels.
     * @param x X-Koordinate des Pixels.
     * @param y Y-Koordinate des Pixels.
     * @param farbe Der Farbwert, der zu setzen ist.
     */
    public void setzeFarbe(int x, int y, java.awt.Color farbe) {
        this.pixelMatrix[x][y] = farbe;
    }
    /**
     * Setzt die Farbe eines Pixels.
     * @param pixel X- und Y-Koordinaten des Pixels.
     * @param farbe Der Farbwert, der zu setzen ist.
     */
    public void setzeFarbe(Punkt pixel, java.awt.Color farbe) {
        setzeFarbe(pixel.gibX(), pixel.gibY(), farbe);
    }
    /**
     * Fügt die Nachbarn eines Pixels einer PixelListe hinzu.
     * @param pixel Punkt dessen Nachbarn bestimmt werden sollen.
     * @param pixelListe Liste welcher die Nachbarpunkte hinzugefügt werden.
     */
    public void setzeNachbarn(Punkt pixel, PixelListe pixelListe) {
        //Jeweils X-
        int x = pixel.gibX();
        //...und Y-Koordinate eines Pixels.
        int y = pixel.gibY();
        /*
        Hier werden die Nachbarn gebildet und in kreuzform hinzugefügt. 
        X darf nicht 0 sein, da bei x - 1 = -1 rauskäme, 
        was nicht mehr im Bild läge.
        */
        if (x != 0) {
            pixelListe.fuegeElementListeHinzu(new Punkt(x - 1, y));
        }
        if (y != 0) {
            pixelListe.fuegeElementListeHinzu(new Punkt(x, y - 1));
        }
        /*
        Hier wird überprüft ob das gefüllte Muster noch innerhalb 
        des Bildes liegt. 
        Bei einem 640 x 480px Bild z.B. wäre x = 639. 
        Durch Addition x + 1 käme 640 raus, was auch 
        nicht mehr im Bild läge, da der Index ja bei 1 beginnt.
        */
        if (x != breite - 1) {
            pixelListe.fuegeElementListeHinzu(new Punkt(x + 1, y));
        }
        /*
        Lägen die Punkte außerhalb, wären sie Teil der Begrenzungspunkte 
        und somit nicht mehr Teil der einzufärbenden Fläche.
        */
        if (y != hoehe - 1) {
            pixelListe.fuegeElementListeHinzu(new Punkt(x, y + 1));
        }
    }
    /**
     * Füllt eine Fläche der selben Farbe mit einer anderen.
     * @param startpunkt Der Startpunkt legt die Fläche fest, 
     * die mit der übergebenen Farbe gefüllt werden soll.
     * @param neueFarbe Die zu füllende Farbe.
     */
    public void fuelleFlaeche(Punkt startpunkt, java.awt.Color neueFarbe) {
        //Hier wird die rekursive Datenstruktur aufgebaut.
        PixelListe pixelListe = new PixelListe();
        //Startwert
        java.awt.Color startFarbe = gibFarbe(startpunkt);
        /*
        Wenn der Pixel nicht, dem zu setzenden Pixel in der Farbe ähnelt, 
        dann wird die Fläche eingefärbt.
        */
        if (!startFarbe.equals(neueFarbe)) {
            /*
            Farbe des Ausgangspunktes merken! Den Ausgangspunkt einfärben. 
            Dadurch hat er eine andere Farbe und wird nicht weiter beachtet.
            */
            setzeFarbe(startpunkt, neueFarbe);
            /*
            Die Nachbarpunkte werden in einer rekursiven Liste gemerkt. 
            Diese Nachbarpunkte müssen natürlich existieren, also muss 
            geprüft werden ob diese nicht außerhalb der Bildgrenzen liegen 
            (siehe oben).
            */
            setzeNachbarn(startpunkt, pixelListe);
            PixelListenKnoten momentanKnoten = 
                    pixelListe.liefereKnotenAnPosition(0);
            /*
            Solange es einen momentanen Knoten gibt, 
            wird die Farbe überprüft, ist sie exakt mit dem Pixel, 
            so wird die Fläche über diesen Punkt weiter verbreitet.
            */
            while (momentanKnoten != null) {
                /*
                Danach wird mit einem der Nachbarpunkt weiter gemacht. 
                Welcher das ist, ist egal (also der nächst beste in der 
                rekursiven Liste). 
                Es wird geprüft, ob dieser Punkt die Startfarbe hat, 
                wenn nicht, wird der Punkt nicht weiter beachtet und mit 
                dem nächsten Punkt weiter gemacht.
                */
                Punkt pixel = momentanKnoten.gibFarbe();
                if (gibFarbe(pixel).equals(startFarbe)) {
                    setzeFarbe(pixel, neueFarbe);
                    /*
                    Es werden wiederrum die Nachbarn in derselben rekursiven 
                    Liste abgespeichert so, dass diese Liste am Anfang immer 
                    größer wird (bis zu 4 Pixel, 
                    wobei min. einer doppelt ist). 
                    
                    Doppelt gemerkte Punkte sind trivial, diese werden 
                    schließlich einmal umgefärbt und dann 
                    nicht mehr beachtet!
                    */
                    setzeNachbarn(pixel, pixelListe);
                }
                //Danach wird über die Liste weiter gegangen.
                momentanKnoten = momentanKnoten.liefereNaechstenKnoten();
                /*Es wird solange weitergemacht, bis die rekursive Liste 
                keine Folgepixel mehr hat.*/
            }
        }
    }
}