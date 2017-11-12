import java.util.HashSet;
import java.util.Set;

class Robot {

    public Robot() {

    }

    public boolean move(Position pos) {
        return true;
    }
    public void turnLeft(int direction) {
    }
    public void turnRight(int direction) {
    }
    public void clean() {
    }
}

class Position {
    int x;
    int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


class RobotClean {
    int[][] offset = {{0,1}, {1,0}, {0,-1}, {-1,0}}; //顺时针
    Set<Position> visited = new HashSet<>();

    public void cleanRoom(Robot robot) {
        Position start = new Position(0, 0);
        visited.add(start);
        robot.clean();
        for (int i = 0; i < 4; i++) {

        }
    }

    private void moveToNewPos(Robot robot, Position pos, int direction, Set<Position> visited) {
        Position newPos = new Position(pos.x + offset[direction][0], pos.y + offset[direction][1]);
        if (visited.contains(newPos)) {
            return;
        }

        if (!robot.move(newPos)) {
            return;
        }

        visited.add(newPos);
        robot.clean();
        robot.turnLeft(direction); // 扭正
        for (int i = 0; i < 4; i++) {
            moveToNewPos(robot, newPos, i, visited);
            robot.turnRight(1); // 1 means 90 degree, after turning 4 times and now it faces north
        }
        robot.turnRight(direction);
        robot.turnRight(2); // 180 turn, look back
        robot.move(pos);
        robot.turnRight(2); // 180 turn, look ahead
    }
}

