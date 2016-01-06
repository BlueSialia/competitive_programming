import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Jorge Dominguez (BlueSialia) <bluesialia+UVa@gmail.com>
 * Verdict: Accepted
 * RunTime: 1.788
 */
public class Main {

    private static Scanner input;
    private final static char[] LETTERS = new char[]{'B','G','C'};

    public static void main(String[] args) {
        input = new Scanner(System.in);
        while (input.hasNext()) {
            int[][] list = new int[3][3];
            int total = 0;

            for (int i = 0; i < 9; i++) {
                int current = input.nextInt();
                list[i/3][i%3] = current;
                total += current;
            }

            LinkedList<String> sol = new LinkedList<String>();
            int max = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != j) {
                        for (int k = 0; k < 3; k++) {
                            if (i != k && j != k) {
                                String currentSol = "";
                                int current = 0;
                                current += list[0][i];
                                currentSol += LETTERS[i];
                                current += list[1][j];
                                currentSol += LETTERS[j];
                                current += list[2][k];
                                currentSol += LETTERS[k];
                                if (current > max) {
                                    max = current;
                                    sol.clear();
                                    sol.add(currentSol);
                                } else if (current == max) {
                                    sol.add(currentSol);
                                }
                            }
                        }
                    }
                }
            }
            String printSol = "ZZZ";
            for (String itString : sol) {
                if (itString.compareTo(printSol) < 0) {
                    printSol = itString;
                }
            }
            System.out.print(printSol);
            System.out.print(" ");
            System.out.println(total - max);
        }
    }

}
