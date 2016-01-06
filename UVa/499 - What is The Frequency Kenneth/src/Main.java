import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Jorge Dominguez (BlueSialia) <bluesialia+UVa@gmail.com>
 * Verdict: None
 * RunTime: 0.000
 */
public class Main {

    private static int[] letters;

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
        letters = new int[128];
        String line = input.nextLine();
        for (int i = 0; i < line.length(); i++) {
            letters[line.charAt(i)] = letters[line.charAt(i)] + 1;
        }
    }

    /**
     * Works with the attributes, calculates the solution and prints it.
     */
    private static void end() {
        int number = 0;
        for (int letter : letters) {
            number = Math.max(number, letter);
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == number) {
                list.add((char)i);
            }
        }
        output(list, number);
    }

    /**
     * Prints the solution in the correct form.
     * @param solution
     *            - Solution of the problem.
     */
    private static void output(List<Character> list, int number) {
        if (number == 0) {
            System.out.println("\\n");
        } else {
            Collections.sort(list); // TODO
            System.out.println(list.toString() + " " + number);
        }
    }
}
