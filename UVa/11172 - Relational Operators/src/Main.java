import java.util.Locale;
import java.util.Scanner;

/**
 * @author Jorge Dominguez (BlueSialia) <bluesialia+UVa@gmail.com>
 * Verdict: Accepted
 * RunTime: 0.202
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
            int a = input.nextInt(),
                    b = input.nextInt();
            if (a==b) {
                System.out.println("=");
            } else {
                if (a<b) {
                    System.out.println("<");
                } else {
                    System.out.println(">");
                }
            }
        }
        scanner.close();
    }
}
