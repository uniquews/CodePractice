package fb;

import java.util.Random;

public class GetRandomList {
    public int[] getRandomList(int m, int[][] grid) {
        int[] a = new int[grid.length * grid[0].length];
        int[] result = new int[m];

        Random rand = new Random();
        int base = a.length;
        int index = 0;

        while (m > 0) {
            int pos = rand.nextInt(base);
            if (a[pos] == 0) {
                a[pos] = pos;
            }
            if (a[base - 1] == 0) {
                a[base - 1] = base - 1;
            }

            result[index++] = a[pos];
            swap(a, pos, base - 1);
            base--;
            m--;
        }
        return result;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[][] grid = new int[2][2];
        int m = 4;
        GetRandomList test = new GetRandomList();
        int[] result = test.getRandomList(m, grid);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
