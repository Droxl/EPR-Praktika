/**
 * Diese Klasse berechnet mit Hilfe von Varialben den Strompreis 
 * und gibt den günstigeren Tarif aus.
 * @author Droxl
 */
public class Stromrechnung {
    /**
     * Die Klasse berechnet mit Hilfe von Varialben den Strompreis. 
     * Sie gibt dann den günstigeren Tarif aus.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        //Jahresverbrauch in kWh
        int jahresVerbrauch = 3536;
        /*Tarif 1 in Euro pro Monat.*/
        double grundPreis1 = 5.75;
        //in Cent pro kWh
        double verbrauchsPreis1 = 23.49;
        /*Tarif 2 in Euro pro Monat.*/
        double grundPreis2 = 9.85;
        //in Cent pro kWh
        double verbrauchsPreis2 = 22.10;
        /*weitere Varialben für den Verbrauch von Tarif 1...*/
        double jahresGrundPreis1;
        double jahresVerbrauch1;
        double gesamtVerbrauch1;
        /*...und Tarif 2.*/
        double jahresGrundPreis2;
        double jahresVerbrauch2;
        double gesamtVerbrauch2;
        /*Varialbe zur Ausgabe des günstigeren Tarifs.*/
        double istGuenstiger;
        /*Multiplikation mit 100 und Addtion 
        mit 0,5 für volle Cents vor dem Kommer.*/
        jahresGrundPreis1 = ((grundPreis1 * 12) * 100 + 0.5);
        /*Rundung auf volle Cents durch Abschneiden des Rests hinter 
        dem Komma.*/
        jahresGrundPreis1 = ((int) jahresGrundPreis1);
        /*Verbrauchspreis in Cent * verbrauchte kWh + 0,5 
        um Reste hinter dem Komma zu eliminieren.*/
        jahresVerbrauch1 = ((verbrauchsPreis1 * jahresVerbrauch) + 0.5);
        /*Konvertierung auf volle Cents durch Abschneiden der Reste.*/
        jahresVerbrauch1 = ((int) jahresVerbrauch1);
        /*Addition und Division mit 100, zur Konvertierung ins Euro-Format.*/
        gesamtVerbrauch1 = (jahresGrundPreis1 + jahresVerbrauch1) / 100;
        /*Das ganze für Tarif 2: Multiplikation mit 100 
        und Addtion mit 0,5 fuer volle Cents vor dem Komma.*/
        jahresGrundPreis2 = ((grundPreis2 * 12) * 100 + 0.5);
        /*Rundung auf volle Cents durch Abschneiden des Rests hinter 
        dem Komma.*/
        jahresGrundPreis2 = ((int) jahresGrundPreis2);
        /*Verbrauchspreis in Cent * verbrauchte kWh + 0,5 
        um Reste hinter dem Komma zu eliminieren.*/
        jahresVerbrauch2 = ((verbrauchsPreis2 * jahresVerbrauch) + 0.5);
        /*Konvertierung auf volle Cents, damit Reste wirklich verschwinden.*/
        jahresVerbrauch2 = ((int) jahresVerbrauch2);
        /*Addition und Division mit 100, zur Konvertierung ins Euro-Format.*/
        gesamtVerbrauch2 = (jahresGrundPreis2 + jahresVerbrauch2) / 100;
        /*Entscheidung für den günstigeren der beiden Tarife.*/
        istGuenstiger = (gesamtVerbrauch1 < gesamtVerbrauch2)
                ? gesamtVerbrauch1
                : gesamtVerbrauch2;
        System.out.println(istGuenstiger);
    }
}