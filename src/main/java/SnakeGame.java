import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by shuaiwang on 4/14/17.
 */
public class SnakeGame {

    private LinkedList<int[]> snake;
    private int maxRow;
    private int maxCol;
    private int [][] f;
    private int currentFood;
    private HashSet<Integer> body;
    public SnakeGame(int width, int height, int[][] food) {
        snake = new LinkedList<>();
        body = new HashSet<>();
        maxRow = height;
        maxCol = width;
        f = food;
        if (f != null && f.length != 0 && f[0] != null) {
            currentFood = 0;
        }
        snake.add(new int[]{0,0});
        body.add(0);
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int parentRow = snake.peek()[0], parentCol = snake.peek()[1];
        boolean foundFood = false;
        if (direction.equals("U")) {
            parentRow = parentRow - 1;
        } else if (direction.equals("D")) {
            parentRow = parentRow + 1;
        } else if (direction.equals("L")) {
            parentCol = parentCol - 1;
        } else {
            parentCol = parentCol + 1;
        }

        if (f != null && currentFood < f.length && f[currentFood][0] == parentRow && f[currentFood][1] == parentCol) {
            foundFood = true;
            currentFood = currentFood + 1;
        }

        if (!foundFood) {
            int[] end = snake.peekLast();
            snake.removeLast();
            body.remove(end[0] * maxCol + end[1]);
        }

        if (parentRow < 0 || parentRow == maxRow || parentCol < 0 || parentCol == maxCol ||
                body.contains(parentRow * maxCol + parentCol)) {
            return -1;
        }

        snake.addFirst(new int[]{parentRow, parentCol});
        body.add(parentRow * maxCol + parentCol);

        return body.size() - 1;
    }

    public static void main(String[] args) {
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
