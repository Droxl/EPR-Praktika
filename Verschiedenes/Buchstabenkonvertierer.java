/**
 * Diese Klasse konvertiert Großbuchstaben zu Kleinbuchstaben 
 * und Kleinbuchstaben zu Großbuchstaben, ohne "Nicht-Buchstaben" zu verändern.
 * @author Droxl
 */
public class Buchstabenkonvertierer {
    /**
     * Diese Methode konvertiert Großbuchstaben zu Kleinbuchstaben 
     * und Kleinbuchstaben zu Großbuchstaben.
     * @param c Das Zeichen, welches verändert wird.
     * @return Gibt den gegenteiligen Buchstabentyp aus zur Eingabe aus.
     */
    public static char konvertiereZeichen(char c) {
        return (char) ((c >= 'A' && c <= 'Z')
                ? (char) c - 'A' + 'a'
                        : c >= 'a' && c <= 'z'
                                ? (char) (c - 'a') + 'A'
                                : c);
    }
    /**
     * Hauptmethode, die die obigen Methoden ausführt.
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {
        /*Konveriert Zeichen a zu --> A...*/
        System.out.println(konvertiereZeichen('a'));
        System.out.println(konvertiereZeichen('b'));
        System.out.println(konvertiereZeichen('c'));
        System.out.println(konvertiereZeichen('d'));
        System.out.println(konvertiereZeichen('e'));
        System.out.println(konvertiereZeichen('f'));
        System.out.println(konvertiereZeichen('g'));
        System.out.println(konvertiereZeichen('h'));
        System.out.println(konvertiereZeichen('i'));
        System.out.println(konvertiereZeichen('j'));
        System.out.println(konvertiereZeichen('k'));
        System.out.println(konvertiereZeichen('l'));
        System.out.println(konvertiereZeichen('m'));
        System.out.println(konvertiereZeichen('n'));
        System.out.println(konvertiereZeichen('o'));
        System.out.println(konvertiereZeichen('p'));
        System.out.println(konvertiereZeichen('q'));
        System.out.println(konvertiereZeichen('r'));
        System.out.println(konvertiereZeichen('s'));
        System.out.println(konvertiereZeichen('t'));
        System.out.println(konvertiereZeichen('u'));
        System.out.println(konvertiereZeichen('v'));
        System.out.println(konvertiereZeichen('w'));
        System.out.println(konvertiereZeichen('x'));
        System.out.println(konvertiereZeichen('y'));
        System.out.println(konvertiereZeichen('z'));
        /*Konvertiert Zeichen A zu --> a...*/
        System.out.println(konvertiereZeichen('A'));
        System.out.println(konvertiereZeichen('B'));
        System.out.println(konvertiereZeichen('C'));
        System.out.println(konvertiereZeichen('D'));
        System.out.println(konvertiereZeichen('E'));
        System.out.println(konvertiereZeichen('F'));
        System.out.println(konvertiereZeichen('G'));
        System.out.println(konvertiereZeichen('H'));
        System.out.println(konvertiereZeichen('I'));
        System.out.println(konvertiereZeichen('J'));
        System.out.println(konvertiereZeichen('K'));
        System.out.println(konvertiereZeichen('L'));
        System.out.println(konvertiereZeichen('M'));
        System.out.println(konvertiereZeichen('N'));
        System.out.println(konvertiereZeichen('O'));
        System.out.println(konvertiereZeichen('P'));
        System.out.println(konvertiereZeichen('Q'));
        System.out.println(konvertiereZeichen('R'));
        System.out.println(konvertiereZeichen('S'));
        System.out.println(konvertiereZeichen('T'));
        System.out.println(konvertiereZeichen('U'));
        System.out.println(konvertiereZeichen('V'));
        System.out.println(konvertiereZeichen('W'));
        System.out.println(konvertiereZeichen('X'));
        System.out.println(konvertiereZeichen('Y'));
        System.out.println(konvertiereZeichen('Z'));
        /*Bleibt so @.*/
        System.out.println(konvertiereZeichen('@'));
    }
}