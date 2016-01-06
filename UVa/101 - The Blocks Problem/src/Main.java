import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jorge Dominguez (BlueSialia) <bluesialia+UVa@gmail.com>
 * Verdict: None
 * RunTime: N/A
 */
public class Main {

    private static ArrayList<Node<Integer>> world;

    private static class Node<E> {
        E value;
        Node <E> next;

        Node(E pValue) {
            value = pValue;
            next = null;
        }

        Node<E> search(E pValue) {
            if (value==pValue) {
                return this;
            } else if (next!=null) {
                return next.search(pValue);
            } else {
                return null;
            }
        }

        void addHere(E pValue) {
            next = new Node<E>(pValue);
        }

        void addLast(E pValue) {
            if (next!=null) {
                next.addLast(pValue);
            } else {
                addHere(pValue);
            }
        }

        void remove(E pValue) {
            if (next!=null) {
                if (next.value==pValue) {
                    next = next.next;
                } else {
                    next.remove(pValue);
                }
            }
        }

        void removeAbove(E pValue) {
            if (next!=null) {
                if (next.value==pValue) {
                    next = null;
                } else {
                    next.remove(pValue);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        world = new ArrayList<Node<Integer>>(input.nextInt());
        int i = 0;
        for (Node<Integer> list : world) {
            list = new Node<Integer>(i);
            i++;
        }
        String line = input.nextLine();
        while (!line.equals("quit")) {
            ejecuteCommand(line);
            line = input.nextLine();
        }
    }
    private static void ejecuteCommand(String line) {
        String[] read = line.split("\\s");
        int commandA = Integer.parseInt(read[1]),
                commandB = Integer.parseInt(read[3]);
        if (!isIllegal(commandA, commandB)) {
            if (read[0].equals("move")) {
                if (read[2].equals("onto")) {
                    moveOnto(commandA, commandB);
                } else if (read[2].equals("over")) {
                    moveOver(commandA, commandB);
                }
            } else if (read[0].equals("pile")) {
                if (read[2].equals("onto")) {
                    pileOnto(commandA, commandB);
                } else if (read[2].equals("over")) {
                    pileOver(commandA, commandB);
                }
            }
        }
    }
    private static boolean isIllegal(int a, int b) {
        int posA = pos(a),
                posB = pos(b);
        return a==b || posA==posB || posA==-1 || posB==-1;
    }
    private static int pos(int a) {
        for (Node<Integer> list : world) {
            if (list.search(a) != null) {
                return world.indexOf(list);
            }
        }
        return -1;
    }
    private static void move(Integer a, int pos) {
        world.get(pos(a)).remove(a);
        world.get(pos).addLast(a);
    }
    private static void moveOnto(Integer a, Integer b) {

    }
    private static void moveOver(Integer a, Integer b) {
    }
    private static void pileOnto(Integer a, Integer b) {
    }
    private static void pileOver(Integer a, Integer b) {
    }
}
