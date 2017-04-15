import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by shuaiwang on 4/14/17.
 */
public class SnakeGame {

    private List<int[]> snake;
    private int maxRow;
    private int maxCol;
    private int [][] f;
    private int currentFood;
    private HashSet<Integer> body;
    public SnakeGame(int width, int height, int[][] food) {
        snake = new ArrayList<>();
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
        int parentRow = snake.get(0)[0], parentCol = snake.get(0)[1];
        boolean foundFood = false;
        if (direction.equals("U")) {
            parentRow = snake.get(0)[0] - 1;
        } else if (direction.equals("D")) {
            parentRow = snake.get(0)[0] + 1;
        } else if (direction.equals("L")) {
            parentCol = snake.get(0)[1] - 1;
        } else {
            parentCol = snake.get(0)[1] + 1;
        }

        if (parentRow < 0 || parentRow == maxRow || parentCol < 0 || parentCol == maxCol ||
                body.contains(parentRow * maxCol + parentCol)) {
            return -1;
        }

        if (f != null && currentFood < f.length && f[currentFood][0] == parentRow && f[currentFood][1] == parentCol) {
            foundFood = true;
            currentFood = currentFood + 1;
        }

        int index = 0;
        while (index < snake.size()) {
            int[] currentPoint = snake.get(index);
            int nextParentRow = currentPoint[0];
            int nextParentCol = currentPoint[1];

            currentPoint[0] = parentRow;
            currentPoint[1] = parentCol;

            body.add(parentRow * maxCol + parentCol);

            if (index == snake.size() - 1) {
                int[] increase = new int[]{nextParentRow, nextParentCol};
                if (foundFood) {
                    if (body.contains(nextParentRow * maxCol + nextParentCol)) {
                        return -1;
                    } else {
                        snake.add(increase);
                    }
                } else {
                    body.remove(nextParentRow * maxCol + nextParentCol);
                }
            }
            parentRow = nextParentRow;
            parentCol = nextParentCol;
            index++;
        }
        return body.size() - 1;
    }

    public static void main(String[] args) {
        int[][] n ={{1,0}};
        SnakeGame test = new SnakeGame(2,2, n);
        test.move("R");
        test.move("D");
        test.move("L");
        test.move("U");
        test.move("R");
    }
}
