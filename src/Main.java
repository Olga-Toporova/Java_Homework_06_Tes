import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static int[][] map = {
            {-1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, 0, -1, 0, -1, 0, 0, 0, -1},
            {-1, 0, 0, 0, -1, -1, 0, 0, -1},
            {-1, 0, 0, 0, -1, -1, 0, 0, -1},
            {-1, 0, -1, 0, 0, 0, 0, 0, -1},
            {-1, 0, -1, -1, 0, 0, -1, -1, -1},
            {-1, 0, 0, 0, 0, 0, -1, -1, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1},
    };
    static int[] GOAL1 = {1, 6};
    static int[] GOAL2 = {7, 2};
    static int[] GOAL3 = {7, 6};
    static int EMPTY = 0;
    static int[] START = {1, 1};
    static int[][] MOVES = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    
    public static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != -1) {
                    System.out.print(" " + map[i][j] + " ");
                } else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void findPath(int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        q.add(START);

        while (!q.isEmpty()) {
            int[] curPoint = q.poll();
            int curRow = curPoint[0];
            int curCol = curPoint[1];

            for (int[] move : MOVES) {
                int newRow = curRow + move[0];
                int newCol = curCol + move[1];
                int[] point = {newRow, newCol};

                if (map[newRow][newCol] == EMPTY) {
                    map[newRow][newCol] = map[curRow][curCol] + 1;
                    q.add(point);
                }
            }
        }
        printMap(map);

        ArrayList list = new ArrayList();
        int g1 = map[GOAL1[0]][GOAL1[1]];
        int g2 = map[GOAL2[0]][GOAL2[1]];
        int g3 = map[GOAL3[0]][GOAL3[1]];
        list.add(g1);
        list.add(g2);
        list.add(g3);
        Collections.sort(list);
        System.out.println("первая цель = " + g1 + ", вторая цель = " + g2 + ", третья цель = " + g3);
        System.out.println("Кратчайший путь занял: " + list.get(0) + " ходов.");
    }

    public static void main(String[] args) {
        printMap(map);
        System.out.println();
        findPath(map);
    }
}