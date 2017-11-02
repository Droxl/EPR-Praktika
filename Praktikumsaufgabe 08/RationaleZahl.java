/**
 * Klasse deren Objekte rationale Zahlen repräsentieren und die 
 * die nachfolgenden Methoden enthält.
 * @author Droxl
 */
public class RationaleZahl {
    /**
     * Zähler einer Rationalen Zahl.
     */
    private long zaehler;
    /**
     * Nenner einer Rationalen Zahl.
     */
    private long nenner;
    /**
     * Erzeugt eine rationale Zahl.
     * @param zaehler Variable für den Zähler einer Zahl.
     * Der Nenner wird automatisch auf 1 gesetzt.
     * Verwendung bei ganzen Zahlen.
     */
    public RationaleZahl(long zaehler) {
        this.zaehler = zaehler;
        this.nenner = 1L;
    }
    /**
     * Erzeugt eine rationale Zahl.
     * @param zaehler Variable für den Zähler einer Zahl.
     * @param nenner Variable für den Nenner einer Zahl.
     * Verwendung bei echten Brüchen.
     */
    public RationaleZahl(long zaehler, long nenner) {
        this.zaehler = zaehler;
        this.nenner = nenner;
    }
    /**
     * Addiert zwei rationale Zahlen miteinander...
     * @param rz Parameter zur Übergabe der zweiten rationalen Zahl, 
     * die mit der ersten addiert wird.
     * @return ...und gibt das Ergebnis aus.
     */
    public RationaleZahl addiere(RationaleZahl rz) {
        /*Neues "RationaleZahl"-Objekt als Resultat der Addition des ersten 
        Objekts mit dem zweiten "RationaleZahl"-Objekt als Parameter.*/
        return new RationaleZahl(
                /*Das kleinste gemeinsame Vielfache lässt sich durch die 
                Formel: Erste Zahl mal zweite Zahl geteilt durch den größten 
                gemeinsamen Teiler der ersten und zweiten Zahl, 
                kurz: kgV = (erste Zahl * zweite Zahl) / ggT(
                erste Zahl, zweite Zahl), bilden.*/
                rz.nenner / ggT(this.nenner, rz.nenner) * this.zaehler 
                        + this.nenner / ggT(this.nenner, 
                                rz.nenner) * rz.zaehler, 
                this.nenner / ggT(this.nenner, rz.nenner) * rz.nenner);
    }
    /**
     * Liefert den größten gemeinsamen Teiler zweier positiver, ganzer Zahlen.
     * @param ersteZahl erste Zahl
     * @param zweiteZahl zweite Zahl
     * @return Größter gemeinsamer Teiler beider Zahlen.
     */
    public long ggT(long ersteZahl, long zweiteZahl) {
        /*Endrekursive Realisierung nach Euklid.*/
        return (zweiteZahl == 0)
                ? ersteZahl
                : ggT(zweiteZahl, ersteZahl % zweiteZahl);
    }
    /**
     * Die Methode gibt eine textuelle Darstellung dieser rationalen Zahl aus, 
     * (wobei die Zahl in ihrer maximal gekürzten Form dargestellt wird).
     * @return Gibt eine textuelle Darstellung dieser rationalen Zahl zurück. 
     * 
     * Ist die Zahl ein echter Bruch wird sie im Format "Zähler/Nenner" 
     * wiedergegeben, ist sie ganzzahlig wird sie im Format 
     * "Zahl" wiedergegeben.
     */
    public String gibAlsText() {
        /*Hier wird jeweils der größte gemeinsame Teiler des letzten 
        "RationaleZahl"-Objekts berechnet...*/
        long ggT = ggT(this.zaehler, this.nenner);
        //...und jeweils der letzte Zähler durch ihn dividiert...
        this.zaehler = this.zaehler / ggT;
        /*...sowie der letzte Nenner durch ihn dividiert, 
        um ein maximal gekürztes "RationaleZahl"-Objekt zu erzeugen.*/
        this.nenner = this.nenner / ggT;
        return (RationaleZahl.this.nenner == 1)
                /*Wenn es sich um eine Ganze Zahl ohne Nenner handelt, 
                also der Nenner = 1 ist, wird nur der Zähler dargestellt.*/
                ? "" + RationaleZahl.this.zaehler
                /*Handelt es sich um einen echten Bruch, 
                werden Zähler und Nenner dargestellt.*/
                : "" + RationaleZahl.this.zaehler
                + "/" + RationaleZahl.this.nenner;
    }
}