import java.io.IOException;

/**
 * @author Jorge Dominguez (BlueSialia) <bluesialia+UVa@gmail.com>
 * Verdict: Accepted
 * RunTime: 0.855
 */
public class Main {

    /**
     * Main program
     */
    public static void main(String[] args) {
        int current;
        boolean first = true;
        try {
            while ((current = System.in.read()) >= 0) {
                if (current == '"') {
                    if (first) {
                        System.out.print("``");
                        first = false;
                    } else {
                        System.out.print("''");
                        first = true;
                    }
                } else {
                    System.out.print((char)current);
                }
            }
        } catch (IOException ignored) {
        }
    }
}
