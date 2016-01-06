import java.util.Scanner;

/**
 * @author Jorge Dominguez (BlueSialia) <bluesialia+UVa@gmail.com>
 * Veredict: Accepted
 * RunTime: 0.285
 */
public class Main {

    private static Scanner input;
    private static int SIZE = 3000000;
    private static int[] calculated = new int[SIZE];

    public static void main(String[] args) {
        input = new Scanner(System.in);
        while (input.hasNext()) {
            long inf = input.nextLong(),
                    sup = input.nextLong(),
                    max = 0;
            System.out.print(inf);
            System.out.print(" ");
            System.out.print(sup);
            System.out.print(" ");
            if (sup < inf) {
                long aux = inf;
                inf = sup;
                sup = aux;
            }
            for (long i = inf; i <= sup; i++) {
                long dist = algorithm(i);
                if (max < dist) {
                    max = dist;
                }
            }
            System.out.println(max);
        }

    }

    private static int algorithm(long num) {
        int dist;
        if (num < SIZE) {
            dist = calculated[(int) num];
            if (dist == 0) {
                dist = distance(num);
                calculated[(int) num] = dist;
            }
        } else {
            dist = distance(num);
        }

        return dist;
    }

    private static int distance(long num) {
        int dist;
        if (num == 1) {
            dist = 1;
        } else if (num % 2 == 0) {
            dist = algorithm(num/2) + 1;
        } else {
            dist = algorithm(3*num + 1) + 1;
        }
        return dist;
    }

}
