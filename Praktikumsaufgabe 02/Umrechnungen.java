/**
 * Dise Klasse dient zur Umrechnung der gegebenen Beträge nach der jeweiligen 
 * Formel und sie liefert die erwarteten Ergebnisse, in dem anderen Format.
 * @author Droxl
 */
public class Umrechnungen {
    /**
     * Die Methode rechnet die gegebenen Beträge nach der jeweiligen 
     * Formel um und gibt dann die Ergebnisse aus.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        /*Rechnet Grad Fahrenheit in Grad Celsius um 
        und gibt das Ergebnis aus.*/
        System.out.println((40 - 32) * 5 / 9);
        System.out.println((41 - 32) * 5 / 9);
        /*Rechnet DM-Beträge in Euro-Beträge um und gibt das Ergebnis aus.*/
        System.out.println(100 * 100_000 / 195583);
        System.out.println(10_000 * 100_000 / 195583);
        /*Liefert zu einer Anzahl Minuten die vollen Stunden 
        und verbleibenden Minuten im Format hmm.
        
        Teilt Betrag durch 60 und multipliziert das Ergebnis mit 100 
        um auf das Format hmm zu gelangen, danach wird der Ursprungsbetrag 
        mit dem Restwertoperator durch 60 dividiert um die verbleibenden 
        Minuten auszugeben.*/
        System.out.println((5 / 60) * 100 + (5 % 60));
        System.out.println((59 / 60) * 100 + (59 % 60));
        System.out.println((60 / 60) * 100 + (60 % 60));
        System.out.println((61 / 60) * 100 + (61 % 60));
        System.out.println((825 / 60) * 100 + (825 % 60));
    }
}