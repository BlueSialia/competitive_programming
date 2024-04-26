import java.util.Locale;
import java.util.Scanner;

/**
 * @author Jorge Dominguez (BlueSialia) <bluesialia+UVa@gmail.com>
 * Verdict: Accepted
 * RunTime: 0.222
 */
public class Main {

    private static int[][] points;

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
        int set = input.nextInt();
        points = new int[set][2];
        for (int i = 0; i < set; i++) {
            points[i][0] = input.nextInt();
            points[i][1] = input.nextInt();
        }
    }

    /**
     * Works with the attributes, calculates the solution and prints it.
     */
    private static void end() {
        double[] distanciaHasta = new double[points.length];
        //int[][] vengoDe = new int[points.length][];

        distanciaHasta[1] = 2*straigthLine(points[0], points[1]);
        //vengoDe[1] = points[0];
        for (int i = 2; i < points.length; i++) {
            distanciaHasta[i] = Integer.MAX_VALUE;
            double distanciaHastaPuntoIDesdeJ = 0;
            for (int j = i-2; j > -1; j--) {
                distanciaHastaPuntoIDesdeJ += straigthLine(points[j+1], points[j+2]);
                double recorridoBitonico = distanciaHastaPuntoIDesdeJ + straigthLine(points[j], points[i]) + distanciaHasta[j+1] - straigthLine(points[j], points[j+1]);
                if (recorridoBitonico < distanciaHasta[i]) {
                    distanciaHasta[i] = recorridoBitonico;
                    //vengoDe[i] = points[j];
                }
            }
        }
        System.out.printf("%.2f\n", distanciaHasta[distanciaHasta.length-1]);
    }

    private static double straigthLine(int[] point1, int[] point2) {
        return Math.sqrt(Math.pow(point1[0]-point2[0], 2)+Math.pow(point1[1]-point2[1], 2));
    }
}
