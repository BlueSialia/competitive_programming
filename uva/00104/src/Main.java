import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Jorge Dominguez (BlueSialia) <bluesialia+UVa@gmail.com>
 * Verdict: Time Limit
 * RunTime: 3.000
 */
public class Main {

    private static double[][] table;

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
        table = new double[input.nextInt()][];
        for (int i = 0; i < table.length; i++) {
            table[i] = new double[table.length];
            for (int j = 0; j < table.length; j++) {
                if (i == j) {
                    table[i][j] = 1.0;
                } else {
                    table[i][j] = input.nextDouble();
                }
            }
        }
    }

    /**
     * Works with the attributes, calculates the solution and prints it.
     */
    private static void end() {
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        Queue<Double> profits = new LinkedList<>();
        for (int i = 0; i < table.length; i++) {
            ArrayList<Integer> insert = new ArrayList<>();
            insert.add(i);
            queue.offer(insert);
            profits.offer(1.0);
        }
        List<Integer> solution = null;
        do {
            ArrayList<Integer> currentList = queue.poll();
            double currentProfit = profits.poll();
            int firstPos = currentList.get(0),
                    lastPos = currentList.get(currentList.size()-1);
            if (currentProfit*table[lastPos][firstPos] > 1.01) {
                solution = currentList;
            } else {
                for (int i = 0; i < table.length; i++) {
                    if (i != lastPos) {
                        @SuppressWarnings("unchecked")
                        ArrayList<Integer> newCurrent = (ArrayList<Integer>) currentList.clone();
                        newCurrent.add(i);
                        queue.offer(newCurrent);
                        profits.offer(currentProfit*table[lastPos][i]);
                    }
                }
            }
        } while (solution==null && queue.element().size()<=(table.length+1));

        output(solution);
    }

    /**
     * Prints the solution in the correct form.
     *
     * @param solution
     *            - Solution of the problem.
     */
    private static void output(List<Integer> solution) {
        if (solution==null) {
            System.out.println("no arbitrage sequence exists");
        } else {
            for (Integer integer : solution) {
                System.out.print(integer+1 + " ");
            }
            System.out.print(solution.get(0)+1);
            System.out.println();
        }
    }
}
