package b;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 4/29/17.
 */
public class ConvexPolygonTest {
    @Test
    public void test() {
        ConvexPolygon test = new ConvexPolygon();
        int[][] points = {{0, 0}, {0, 10}, {10, 10}, {10, 0}, {5, 5}};
        assertThat(test.isConvex(points)).isFalse();
    }

    @Test
    public void test2() {
        ConvexPolygon test = new ConvexPolygon();
        int[][] points = {{0, 0}, {0, 10}, {10, 10}, {10, 0}};
        assertThat(test.isConvex(points)).isTrue();
    }
}
