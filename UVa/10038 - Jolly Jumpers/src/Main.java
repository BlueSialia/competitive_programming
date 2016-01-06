import java.util.Locale;
import java.util.Scanner;

/**
 * @author Jorge Dominguez (BlueSialia) <bluesialia+UVa@gmail.com>
 * Verdict: Accepted
 * RunTime: 0.545
 */
public class Main {

    private static int[] numbers;

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
        numbers = new int[input.nextInt()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }
    }

    /**
     * Works with the attributes, calculates the solution and prints it.
     */
    private static void end() {
        boolean[] n = new boolean[numbers.length - 1];
        try {
            for (int i = 0; i < n.length; i++) {
                n[Math.abs(numbers[i+1] - numbers[i]) - 1] = true;
            }
            int i = 0;
            while (i < n.length && n[i]) {i++;}
            if (i == n.length) {
                System.out.println("Jolly");
            } else {
                System.out.println("Not jolly");
            }
        } catch (Exception e) {
            System.out.println("Not jolly");
        }
    }
}
