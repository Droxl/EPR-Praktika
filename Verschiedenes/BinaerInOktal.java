/**
 * Die folgende Methode wandelt Binärzahlen in Oktalzahlen um.
 * @author Droxl
 */
public class BinaerInOktal {
    /**
     * Wandelt Binaerzaheln in Oktalzahlen um.
     * @param binaer übergibt die Binaerzahl.
     * @return Gibt die Oktaldarstellung zurück.
     */
    public static long binaerInOktal(long binaer) {
        return binaer <= 111
                ? binaer % 10 + 2 * binaer / 10 % 10 + 4 * binaer / 100 % 10
                : binaer % 10 + 2 * binaer / 10 % 10 + 4 * binaer / 100 % 10 
                + binaerInOktal(binaer / 1_000) * 10;
    }
    /**
     * Die Hauptmethode testet die obige Methode auf Funktionalität.
     * @param args findet keine Verwendung.
     */
    public static void main(String[] args) {
        System.out.println(binaerInOktal(1001110));
    }
}