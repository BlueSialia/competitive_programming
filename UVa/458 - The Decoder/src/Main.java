import java.io.IOException;

/**
 * @author Jorge Dominguez (BlueSialia) <bluesialia+UVa@gmail.com>
 * Verdict: Time Limit
 * RunTime: 3.000
 */
public class Main {

    /**
     * Main program
     */
    public static void main(String[] args) {
        int current;
        String output = "";
        try {
            while ((current = System.in.read()) >= 0) {
                if (current == 10 || current == 13) {
                    output += (char)current;
                } else {
                    output += (char)(current-7);
                }
            }
        } catch (IOException ignored) {
        }
        System.out.println(output);
    }
}
