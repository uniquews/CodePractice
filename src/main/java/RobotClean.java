class Robot {
    int x;
    int y;
    char face;

    public Robot(int xx, int yy, char f) {
        x = xx;
        y  = yy;
        face = f;
    }
    public boolean move() {
        return true;
    }
    public void turnLeft() {
    }
    public void turnRight() {
    }
    public void clean() {
    }

    public boolean helper(int posX, int posY) {
        if (posX < x) {
            // down
            if (face == 'N') {
                // right turn twice
            } else if (face == 'S') {
                // do nothing
            } else if (face == 'W') {
                // turn left
            } else { // 'E'
                // turn right
            }
        } else if (posX > x) {
            // up
            if (face == 'N') {
                // do nothing
            } else if (face == 'S') {
                // right turn twice
            } else if (face == 'W') {
                // turn right
            } else { // 'E'
                // turn left
            }
        } else if (posY < y) {
            // left
            if (face == 'N') {
                // turn left
            } else if (face == 'S') {
                // turn right
            } else if (face == 'W') {
                // do nothing
            } else { // 'E'
                // right turn twice
            }
        } else { // posY > Y
            // right
            if (face == 'N') {
                // turn right
            } else if (face == 'S') {
                // turn left
            } else if (face == 'W') {
                // right turn twice
            } else { // 'E'
                // do nothing
            }
        }
        boolean res = move();
        if (res) {
            clean();
        }
        return res;
    }
}


class RobotClean {
    Robot robot;
    int[][] direction = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] map;
    boolean[][] cleaned;

    public RobotClean(int xx, int yy, int[][] grid, char f) {
        robot = new Robot(xx, yy, f);
        map = grid;
        cleaned = new boolean[map.length][map[0].length];
    }

    void work(int m, int n) {
        for (int i = 0; i < direction.length; i++) {
            int posX = m + direction[i][0];
            int posY = n + direction[i][1];
            if (cleaned[posX][posY] || !robot.helper(posX, posY))
                continue;
            cleaned[posX][posY] = true;
            work(posX, posY);
            robot.helper(m, n);
        }
    }
}

