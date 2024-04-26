import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Jorge Dominguez (BlueSialia) <bluesialia+UVa@gmail.com>
 * Verdict: Accepted
 * RunTime: 0.445
 */
public class Main {

    /**
     * Each row is a box and each column is a dimension.
     */
    private static int[][] boxes;

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
        boxes = new int[input.nextInt()][];
        int numDim = input.nextInt();
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new int[numDim];
            for (int j = 0; j < boxes[i].length; j++) {
                boxes[i][j] = input.nextInt();
            }
        }
    }

    /**
     * Works with the attributes, calculates the solution and prints it.
     */
    private static void end() {
        for (int[] boxe : boxes) {                      // Orders the values of
            Arrays.sort(boxe);                          // the dimensions of
        }                                               // each box.

        boolean[][] fits = new boolean[boxes.length][]; // Creates a table of
        for (int i = 0; i < fits.length; i++) {			// booleans and fills
            fits[i] = new boolean[boxes.length];		// it. A true in the row
            for (int j = 0; j < fits[i].length; j++) {	// x, column y means the
                fits[i][j] = fit(i, j);					// box number x fits in
            }											// the box number y.
        }

        ArrayList<Integer> solution = new ArrayList<>();// Starts looking for the
        int max;										// row in 'fits' whit the
        boolean[] current = new boolean[boxes.length];	// max number of trues.
        Arrays.fill(current, true);						// Then repeats it, but
        do {											// only looking in the
            max = -1;									// rows whose related value
            int aux = -1;								// in the last row found
            for (int i = 0; i < boxes.length; i++) {	// is true.
                if (current[i] && count(fits[i]) > max) {
                    max = count(fits[i]);				// Saves the number of each
                    aux = i;							// row found in 'solution'.
                }										// Stops when the row with
            }											// the max number of trues
            solution.add(aux + 1);						// haven't got any.
            current = fits[aux];
        } while (max != 0);

        output(solution);
    }

    /**
     * Prints the solution in the correct form.
     *
     * @param solution
     *            - Solution of the problem.
     */
    private static void output(ArrayList<Integer> solution) {
        System.out.println(solution.size());
        for (Integer integer : solution) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    /**
     * Checks if the boxA fits inside boxB.
     *
     * @param boxA
     *            - Number of boxA
     * @param boxB
     *            - Number of boxB
     * @return True if fits, false if doesn't.
     */
    private static boolean fit(int boxA, int boxB) {
        for (int i = 0; i < boxes[boxA].length; i++) {
            if (boxes[boxA][i] >= boxes[boxB][i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Counts the number of trues in the array.
     *
     * @param array
     *            - Array of booleans.
     * @return The number of trues.
     */
    private static int count(boolean[] array) {
        int cont = 0;
        for (boolean b : array) {
            if (b) {
                cont++;
            }
        }
        return cont;
    }
}
