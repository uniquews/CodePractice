/**
 * Created by shuaiwang on 8/15/17.
 */
public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        int horizon = 0;
        int vertical = 0;

        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') {
                vertical++;
            } else if (moves.charAt(i) == 'D') {
                vertical--;
            } else if (moves.charAt(i) == 'L') {
                horizon--;
            } else {
                horizon++;
            }
        }
        return horizon == 0 && vertical == 0;
    }
}
