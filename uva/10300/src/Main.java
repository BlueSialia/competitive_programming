import java.util.Locale;
import java.util.Scanner;

/**
 * @author Jorge Dominguez (BlueSialia) <bluesialia+UVa@gmail.com>
 * Verdict: Accepted
 * RunTime: 0.179
 */
public class Main {

    /**
     * Main program
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner input = scanner.useLocale(Locale.US);
        int cases = input.nextInt();
        for (int i = 0; i < cases; i++) {
            int premium = 0,
                    farmers = input.nextInt();
            for (int j = 0; j < farmers; j++) {
                int size = input.nextInt(),
                        animals = input.nextInt(),
                        degree = input.nextInt();
                premium += size*degree;
            }
            System.out.println(premium);
        }
        scanner.close();
    }
}