import java.util.Locale;
import java.util.Scanner;

/**
 * @author Jorge Dominguez (BlueSialia) <bluesialia+UVa@gmail.com>
 * Verdict: Accepted
 * RunTime: 0.722
 */
public class Main {

    private static int[] city;

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
        city = new int[10000];

        while (input.hasNext()) {
            int left = input.nextInt(),
                    top = input.nextInt(),
                    right = input.nextInt();
            for (int i = left; i < right; i++) {
                if (city[i] < top) {
                    city[i] = top;
                }
            }
        }
    }

    /**
     * Works with the attributes, calculates the solution and prints it.
     */
    private static void end() {
        boolean first = true;
        for (int i = 1; i < city.length; i++) {
            if (city[i] != city[i-1]) {
                if (first) {
                    System.out.print(i + " " + city[i]);
                    first = false;
                } else {
                    System.out.print(" " + i + " " + city[i]);
                }
            }
        }
        System.out.println();
    }
}
