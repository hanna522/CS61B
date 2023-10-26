/**
 * Class that prints Collatz sequence starting from a given number.
 * @author kimhangyeol
 */
public class Collatz {

    /** returns the next number*/
    public static int nextNumber(int n) {
        if (n % 2 == 0) {
            return n/2;
        } else {
            return 3*n+1;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n);
        while  (n > 1) {
            n = nextNumber(n);
            System.out.print(" " + n);
        }
    }

}
