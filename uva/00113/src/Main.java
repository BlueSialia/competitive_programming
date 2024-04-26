import java.util.Locale;
import java.util.Scanner;

/**
 * @author Jorge Dominguez (BlueSialia) <bluesialia+UVa@gmail.com>
 * Verdict: Accepted
 * RunTime: 0.676
 */
public class Main {

    private static double n, p;

    /**
     * Main program
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner input = scanner.useLocale(Locale.US);
        while (input.hasNext()) {
            start(input);
            end();
        }
        scanner.close();
    }

    /**
     * Reads the input and leaves the data in the attributes, in a standard and
     * real-look-alike form.
     *
     * @param input
     *            - Reader for the input.
     */
    private static void start(Scanner input) {
        n = input.nextDouble();
        p = input.nextDouble();
    }

    /**
     * Works with the attributes, calculates the solution and prints it.
     */
    private static void end() {
        System.out.println(Math.round(Math.pow(10, Math.log10(p)/n)));
    }
}