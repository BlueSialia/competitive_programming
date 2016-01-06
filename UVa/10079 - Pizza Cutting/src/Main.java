import java.util.Locale;
import java.util.Scanner;

/**
 * @author Jorge Dominguez (BlueSialia) <bluesialia+UVa@gmail.com>
 * Verdict: Accepted
 * RunTime: 0.186
 */
public class Main {

    private static long number;

    /**
     * Main program
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner input = scanner.useLocale(Locale.US);
        while (input.hasNext() && (number = input.nextLong()) >= 0) {
            System.out.println(((number+1)*number/2)+1);
        }
        scanner.close();
    }
}