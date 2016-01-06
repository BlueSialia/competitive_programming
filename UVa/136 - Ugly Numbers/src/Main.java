/**
 * @author Jorge Dominguez (BlueSialia) <bluesialia+UVa@gmail.com>
 * Verdict: Accepted
 * RunTime: 0.155
 */
public class Main {

    private static long[] list;

    /**
     * Main program
     */
    public static void main(String[] args) {
        list = new long[1500];
        list[0] = 1;
        list[1] = 2;
        list[2] = 3;
        list[3] = 4;
        list[4] = 5;

        System.out.println("The 1500'th ugly number is " + getPos(1499) + ".");
    }
    private static long getPos(int pos) {
        if (list[pos] == 0) {
            list[pos] = Math.min(nextUgly(getPos(pos-1)/2)*2, Math.min(nextUgly(getPos(pos-1)/3)*3, nextUgly(getPos(pos-1)/5)*5));
        }
        return list[pos];
    }
    private static long nextUgly(long ugly) {
        int left = 0,
                right = list.length;
        while (list[left+(right-left)/2] != ugly && right-left != 1) {
            if (list[left+(right-left)/2] == 0 || ugly < list[left+(right-left)/2]) {
                right = left+(right-left)/2;
            } else if (list[left+(right-left)/2] < ugly) {
                left = left+(right-left)/2;
            }
        }
        return list[1+left+(right-left)/2];
    }
}
