/**
 * Created by shuaiwang on 5/4/17.
 */
public class BeautifulArrangement {
    private int result = 0;
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        dfs(1, N, visited);
        return result;
    }

    private void dfs(int index, int N,  boolean[] visited) {
        if (index == N + 1) {
            result++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if ((i % index == 0 || index % i == 0) && !visited[i]) {
                visited[i] = true;
                dfs(index + 1, N, visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int N = 2;
        BeautifulArrangement test = new BeautifulArrangement();
        test.countArrangement(N);
    }
}
