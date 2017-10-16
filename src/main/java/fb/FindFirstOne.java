package fb;

public class FindFirstOne {

    public int findFirstOne(int[][] matrix) {

        int result = matrix.length;

        int r = 0;
        int c = matrix[0].length - 1;

        while (r < matrix.length) {
            if (c >= 0 && matrix[r][c] == 1) {
                c--;
            } else {
                if (c + 1 < matrix[0].length && matrix[r][c + 1] == 1) {
                    result = c + 1;
                }
                r++;
            }
        }
        return result == matrix[0].length ? -1 : result;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{0,0,0,0,0,1,1}, {0,0,0,1,1,1,1}, {0,0,0,0,1,1,1}};
        int[][] matrix = {{1,1,1}, {1,1,1}, {1,1,1}};
        FindFirstOne test = new FindFirstOne();
        System.out.println(test.findFirstOne(matrix));
    }
}
