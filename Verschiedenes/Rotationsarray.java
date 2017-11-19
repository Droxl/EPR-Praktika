/**
 * Diese Klasse veranschaulicht das rotierende Array.
 * @author Droxl
 */
public class Rotationsarray {
    /**
     * Verschiebt Komponenten eines Felds um eine bestimmte Schrittweite.
     * @param zahlenfolge Das Feld auf dem operiert wird.
     * @param schrittweite Die Schrittweite, um die die Werte verschoben werden.
     */
    public static void rotiere(int[] zahlenfolge, int schrittweite) {
        /*
        Hilfsarray mit dessen Hilfe auf dem übergebenen 
        Array operiert werden kann.
        */
        int[] rotierteFolge = new int[zahlenfolge.length];
        /*
        Diese Schleife wandert das übergebene Array ab und sortiert 
        die Werte mittels der Schrittweite in entsprechendem Abstand 
        im Hilfsarray. Dabei sorgt "% zahlenfolge.length" dafür, dass die 
        Größe des Arrays nicht überschritten wird und die Werte in 
        "rotierter Folge" sortiert werden.
        */
        for (int i = 0; i < zahlenfolge.length; i++) {
            rotierteFolge[(i + schrittweite) % zahlenfolge.length] 
                    = zahlenfolge[i];
        }
        /*
        Schreibt die Werte ins übergebene Array in rotierter Folge zurück.
        */
        for (int i = 0; i < zahlenfolge.length; i++) {
            zahlenfolge[i] = rotierteFolge[i];
        }
    }
     /**
     * Gibt die Werte einer Array-Folge ganzer Zahlen auf dem Bildschirm aus.
     * @param folge Zahlenfolge die dargestellt werden soll.
     */
    private static void gibAufBildschirmAus(int[] folge) {
        for (int i = 0; i < folge.length; i = i + 1) {
            System.out.print(folge[i] + " ");
        }
        System.out.println();
    }
    //Array mit dem man die Methode überprüfen kann.
    static int[] array;
    /**
     * Führt die Testmethoden aus und stellt die Testergebnisse auf 
     * dem Bildschirm dar.
     * @param args ist hier belanglos.
     */
    public static void main(String[] args) {
        array = new int[]{1,2,3,4,5,6,7};
        gibAufBildschirmAus(array);
        System.out.println("--------------------------");
        rotiere(array, 3);
        gibAufBildschirmAus(array);
    }
}