import java.util.Locale;
import java.util.Scanner;

/**
 * @author Jorge Dominguez (BlueSialia) <bluesialia+UVa@gmail.com>
 * Verdict: Accepted
 * RunTime: 2.356
 */
public class Main {

    private static int a, b, c;

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
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();
    }

    /**
     * Works with the attributes, calculates the solution and prints it.
     */
    private static void end() {
        double s = (a+b+c)/2.0, // semiperimeter
                triangleArea = Math.sqrt(s*(s-a)*(s-b)*(s-c)), // Heron's formula
                circumcircleArea = circleArea((a*b*c)/(4*triangleArea)),
                incircleArea =circleArea(2*triangleArea/(2*s)),
                sunflowers = circumcircleArea-triangleArea,
                violets = triangleArea-incircleArea,
                roses = incircleArea;

        System.out.printf("%.4f %.4f %.4f\n", sunflowers, violets, roses);
    }

    private static double circleArea(double radius) {
        return Math.PI*Math.pow(radius, 2);
    }
}
