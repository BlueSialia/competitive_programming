import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Jorge Dominguez (BlueSialia) <bluesialia+UVa@gmail.com>
 * Verdict: Accepted
 * RunTime: 0.842
 */
public class Main {

    private static String line;
    private static Map<Character, Character> reverses = new HashMap<>(35);

    /**
     * Main program
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner input = scanner.useLocale(Locale.US);
        initialize();
        while (input.hasNext()) {
            start(input);
            end();
        }
        scanner.close();
    }

    /**
     * Initializes the variable reverses
     */
    private static void initialize() {
        reverses.put('A', 'A');
        reverses.put('E', '3');
        reverses.put('H', 'H');
        reverses.put('I', 'I');
        reverses.put('J', 'L');
        reverses.put('L', 'J');
        reverses.put('M', 'M');
        reverses.put('O', 'O');
        reverses.put('S', '2');
        reverses.put('T', 'T');
        reverses.put('U', 'U');
        reverses.put('V', 'V');
        reverses.put('W', 'W');
        reverses.put('X', 'X');
        reverses.put('Y', 'Y');
        reverses.put('Z', '5');
        reverses.put('1', '1');
        reverses.put('2', 'S');
        reverses.put('3', 'E');
        reverses.put('5', 'Z');
        reverses.put('8', '8');
    }

    /**
     * Reads the input and leaves the data in the attributes, in a standard and
     * real-look-alike form.
     *
     * @param input
     *            - Reader for the input.
     */
    private static void start(Scanner input) {
        line = input.next();
    }

    /**
     * Works with the attributes, calculates the solution and prints it.
     */
    private static void end() {
        boolean palindrome = true,
                mirrored = true;
        int i = 0;
        while ((palindrome || mirrored) && i < line.length()) {
            if (palindrome) {
                palindrome = line.charAt(i) == line.charAt(line.length()-i-1);
            }
            if (mirrored) {
                try {
                    mirrored = line.charAt(i) == reverses.get(line.charAt(line.length()-i-1));
                } catch (Exception e) {
                    mirrored = false;
                }
            }
            i++;
        }
        System.out.print(line);
        if (palindrome && mirrored) {
            System.out.println(" -- is a mirrored palindrome.");
            System.out.println();
        } else if (palindrome) {
            System.out.println(" -- is a regular palindrome.");
            System.out.println();
        } else if (mirrored) {
            System.out.println(" -- is a mirrored string.");
            System.out.println();
        } else {
            System.out.println(" -- is not a palindrome.");
            System.out.println();
        }
    }
}
