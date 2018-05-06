/**
 * Zwei Arten die Fakultät einer Zahl zu ermitteln, einmal durch Rekursion, 
 * einmal via Iteration.
 * @author ich
 */
public class Iteration {
    /**
     * Liefert die Fakultät der eingegebenen Zahl.
     * @param n Eingegebene Zahl dessen Fakultät berechnet wird.
     * @return Die Fakultät der eingegebenen Zahl.
     */
    public static int fakultaet(int n) {
        return (n <= 1)
                ? 1
                : n * fakultaet(n - 1);
    }
    /**
     * Liefert die Fakultät der eingegebenen Zahl.
     * @param n Eingegebene Zahl dessen Fakultät berechnet wird.
     * @return Die Fakultät der eingegebenen Zahl.
     */
    public static int factorial(int n) {
        /*Die Fakultät der eingegebenen Zahl.*/
        int fakultaet = n;
        while(n > 1) {
            n = n - 1;
            fakultaet = fakultaet * n;
        }
        return fakultaet;
    }
}
