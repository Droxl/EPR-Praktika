/**
 * Klasse zur Berechnung der Zinsen.
 * @author Droxl
 */
public class Zinsberechnung {
    /**
     * Berechnungen unter Verwendung von Variablen. 
     * Alle Anweisungen befinden sich in 
     * der Hauptmethode der Klasse Zinsberechnung.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        /*3 Grundvariablen für Euro-, Centbetrag und Zins von 3%.*/
        int euroBetrag = 117;
        int centBetrag = 0;
        int zins = 3;
        /*Weitere Variablen für den Zinseszins.*/
        int euroKapital;
        int centKapital;
        /*Berechnung für ein Jahr mit Bildschirmausgabe.*/
        euroBetrag = euroBetrag * 100 + centBetrag;
        euroKapital = (euroBetrag * (100 + zins)) / 100;
        centKapital = euroKapital % 100;
        System.out.print(euroKapital / 100);
        System.out.print(',');
        System.out.println(centKapital);
        /*Berechnung für zwei Jahre mit Bildschirmausgabe.*/
        euroKapital = (euroKapital * (100 + zins)) / 100;
        centKapital = euroKapital % 100;
        System.out.print(euroKapital / 100);
        System.out.print(',');
        System.out.println(centKapital);
        /*Berechnung für drei Jahre mit Bildschirmausgabe.*/
        euroKapital = (euroKapital * (100 + zins)) / 100;
        centKapital = euroKapital % 100;
        System.out.print(euroKapital / 100);
        System.out.print(',');
        System.out.println(centKapital);
        /*Berechnung für ein Jahr gerundet mit Bildschirmausgabe.*/
        euroKapital = euroBetrag * (100 + zins) / 100;
        centKapital = euroKapital % 100;
        System.out.print(euroKapital / 100);
        System.out.print(',');
        System.out.println(centKapital);
        /*Berechnung für zwei Jahre gerundet mit Bildschirmausgabe.*/
        euroKapital = ((euroKapital * (100 + zins)) + 50) / 100;
        centKapital = euroKapital % 100;
        System.out.print(euroKapital / 100);
        System.out.print(',');
        System.out.println(centKapital);
        /*Berechnung für drei Jahre gerundet mit Bildschirmausgabe.*/
        euroKapital = ((euroKapital * (100 + zins)) + 50) / 100;
        centKapital = euroKapital % 100;
        System.out.print(euroKapital / 100);
        System.out.print(',');
        System.out.println(centKapital);
    }
}