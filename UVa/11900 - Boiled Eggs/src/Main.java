import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Jorge Dominguez (BlueSialia) <bluesialia+UVa@gmail.com>
 * Verdict: None
 * RunTime: 0.000
 */
public class Main {

    private static int max_Eggs;
    private static int mag_Gr;
    private static int[] eggs;

    /**
     * Main program
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner input = scanner.useLocale(Locale.US);
        int cases = input.nextInt();
        for (int i = 0; i < cases; i++) {
            start(input);
            end(i+1);
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
        eggs = new int[input.nextInt()];
        max_Eggs = input.nextInt();
        mag_Gr = input.nextInt();
        for (int i = 0; i < eggs.length; i++) {
            eggs[i] = input.nextInt();
        }
        Arrays.sort(eggs);
    }

    /**
     * Works with the attributes, calculates the solution and prints it.
     */
    private static void end(int num_case) {
        int num_Eggs = 0, num_Gr = 0;
        while (num_Eggs < max_Eggs && num_Gr <= mag_Gr+eggs[num_Eggs] && num_Eggs < eggs.length) {
            num_Gr += eggs[num_Eggs];
            num_Eggs++;
        }
        System.out.println("Case " + num_case + ": " + num_Eggs);
    }
}
