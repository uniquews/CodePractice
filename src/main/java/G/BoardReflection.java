package G;

public class BoardReflection {
    //随机生成bumper， 5/25, 4/24 ...
    public boolean canExist(char[][] board, int x, int y, int[] direct) {

        int[] next;
        int r = x;
        int c = y;
        while (true) {
            next = move(r, c, direct, board);
            r = next[0];
            c = next[1];

            if (r == -1) {
                return true;
            }

            direct = nextDirection(board[r][c], direct);
        }
    }

    private int[] move(int x, int y, int[] direct, char[][] board) {
        int row = board.length;
        int col = board[0].length;
        while (x + direct[0] >= 0 && x + direct[0] < row &&
                y + direct[1] < col && y + direct[1] >= 0) {
            x += direct[0];
            y += direct[1];

            if (board[x][y] == '\\' || board[x][y] == '/') {
                return new int[]{x, y};
            }
        }
        return new int[]{-1, -1};
    }

    private int[] nextDirection(char c, int[] direct) {
        int[] result = new int[2];
        if (c == '/') {
            result[0] = -direct[1];
            result[1] = -direct[0];
        } else if (c == '\\') {
            result[0] = direct[1];
            result[1] = direct[0];
        }
        return result;
    }

    public static void main(String[] args) {
//        char[][] board = {{' ', '/', ' '}, {' ', '/', ' '}};
//        char[][] board = {{' ', '/', ' '}, {' ', '\\', ' '}};
        char[][] board = {{'/', ' '}, {'\\', '/'}};
        BoardReflection test = new BoardReflection();
//        System.out.print(test.canExist(board, 0, 2, new int[]{0, -1}));
        System.out.print(test.canExist(board, 0, 1, new int[]{0, -1}));
    }
}
