import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by shuaiwang on 4/14/17.
 */
public class SnakeGame {
//
//    private LinkedList<int[]> snake;
//    private int maxRow;
//    private int maxCol;
//    private int [][] f;
//    private int currentFood;
//    private HashSet<Integer> body;
//    public SnakeGame(int width, int height, int[][] food) {
//        snake = new LinkedList<>();
//        body = new HashSet<>();
//        maxRow = height;
//        maxCol = width;
//        f = food;
//        if (f != null && f.length != 0 && f[0] != null) {
//            currentFood = 0;
//        }
//        snake.add(new int[]{0,0});
//        body.add(0);
//    }
//
//    /** Moves the snake.
//     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
//     @return The game's score after the move. Return -1 if game over.
//     Game over when snake crosses the screen boundary or bites its body. */
//    public int move(String direction) {
//        int parentRow = snake.peek()[0], parentCol = snake.peek()[1];
//        boolean foundFood = false;
//        if (direction.equals("U")) {
//            parentRow = parentRow - 1;
//        } else if (direction.equals("D")) {
//            parentRow = parentRow + 1;
//        } else if (direction.equals("L")) {
//            parentCol = parentCol - 1;
//        } else {
//            parentCol = parentCol + 1;
//        }
//
//        if (f != null && currentFood < f.length && f[currentFood][0] == parentRow && f[currentFood][1] == parentCol) {
//            foundFood = true;
//            currentFood = currentFood + 1;
//        }
//
//        if (!foundFood) {
//            int[] end = snake.peekLast();
//            snake.removeLast();
//            body.remove(end[0] * maxCol + end[1]);
//        }
//
//        if (parentRow < 0 || parentRow == maxRow || parentCol < 0 || parentCol == maxCol ||
//                body.contains(parentRow * maxCol + parentCol)) {
//            return -1;
//        }
//
//        snake.addFirst(new int[]{parentRow, parentCol});
//        body.add(parentRow * maxCol + parentCol);
//
//        return body.size() - 1;
//    }


    /**
     *
     * 非常容易错的点是：当头和尾巴相邻时，要先判断是否删掉尾巴，在判断头是不是在body中
     *
     * */
    private int row;
    private int col;
    private LinkedList<int[]> snake;
    private Set<Integer> body;
    private LinkedList<int[]> f;
    public SnakeGame(int width, int height, int[][] food) {
        row = height;
        col = width;
        f = new LinkedList<>();
        for (int i = 0; i < food.length; i++) {
            f.add(food[i]);
        }
        snake = new LinkedList<>();
        body = new HashSet<>();
        snake.add(new int[]{0,0});
        body.add(0);
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] mo;
        if (direction.equals("U")) {
            mo = new int[]{-1,0};
        } else if (direction.equals("D")) {
            mo = new int[]{1, 0};
        } else if (direction.equals("L")) {
            mo = new int[]{0, -1};
        } else {
            mo = new int[]{0, 1};
        }

        int[] head = snake.peek();
        int[] next = {head[0] + mo[0], head[1] + mo[1]};
        int nextPos = next[0] * col + next[1];
        if (next[0] < 0 || next[0] == row || next[1] < 0 || next[1] == col) {
            return -1;
        }

        if (f.isEmpty() || !(next[0] == f.peek()[0] && next[1] == f.peek()[1])) {
            int[] prev = snake.removeLast();
            body.remove(prev[0] * col + prev[1]);
        }
        if (!f.isEmpty() && next[0] == f.peek()[0] && next[1] == f.peek()[1]) {
            f.removeFirst();
        }

        if (body.contains(nextPos))
            return -1;

        snake.addFirst(new int[]{next[0], next[1]});
        body.add(next[0] * col + next[1]);
        return snake.size() - 1;
    }

    public static void main(String[] args) {
//        int[][] n ={{1,2}, {0,1}};
//        SnakeGame test = new SnakeGame(3,2, n);
//        test.move("R");
//        test.move("D");
//        test.move("R");
//        test.move("U");
//        test.move("L");
//        test.move("U");
        int[][] n ={{2,0}, {0,0}, {0,2}, {2,2}};
        SnakeGame test = new SnakeGame(3,3, n);
        test.move("D");
        test.move("D");
        test.move("R");
        test.move("U");
        test.move("U");
        test.move("L");
        test.move("D");
        test.move("R");
        test.move("R");
        test.move("U");
        test.move("L");
        test.move("D");
    }
}
