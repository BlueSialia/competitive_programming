import java.util.Locale;
import java.util.Scanner;

/**
 * @author Jorge Dominguez (BlueSialia) <bluesialia+UVa@gmail.com>
 * Verdict: Accepted
 * RunTime: 0.175
 */
public class Main {

    /**
     * Main program
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner input = scanner.useLocale(Locale.US);
        while (input.hasNext()) {
            String[] split = input.nextLine().split("[^a-zA-Z]+");
            if (split.length == 0 || split[0].matches("[a-zA-Z]+")) {
                System.out.println(split.length);
            } else {
                System.out.println(split.length - 1);
            }
        }
        scanner.close();
    }
}
