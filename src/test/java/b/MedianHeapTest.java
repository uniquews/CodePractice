package b;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 7/15/17.
 */
public class MedianHeapTest {
    @Test
    public void test() {
        //[1,3,-1,-3,5,3,6,7] 3
        MedianHeap test = new MedianHeap();
        test.add(1);
        test.add(3);
        test.add(-1);
        assertThat(test.getMedian()).isEqualTo(1.0);
        test.add(-3);
        test.remove(1);
        assertThat(test.getMedian()).isEqualTo(-1.0);
    }

    @Test
    public void test2() {
        //-1,-1,1,-1,-1,-1,1,1,1,1,-1,-1
        MedianHeap test = new MedianHeap();
        test.add(-1);
        assertThat(test.getMedian()).isEqualTo(-1.0);
        test.remove(-1);
        test.add(-1);
        assertThat(test.getMedian()).isEqualTo(-1.0);
        test.remove(-1);
        test.add(1);
        assertThat(test.getMedian()).isEqualTo(1.0);
        test.remove(1);
        test.add(-1);
        assertThat(test.getMedian()).isEqualTo(-1.0);
        test.remove(-1);
        test.add(-1);
        assertThat(test.getMedian()).isEqualTo(-1.0);
        test.remove(-1);
        test.add(-1);
        assertThat(test.getMedian()).isEqualTo(-1.0);
        test.remove(-1);
        test.add(1);
        assertThat(test.getMedian()).isEqualTo(1.0);
        test.remove(1);
        test.add(1);
        assertThat(test.getMedian()).isEqualTo(1.0);
        test.remove(1);
        test.add(1);
        assertThat(test.getMedian()).isEqualTo(1.0);
        test.remove(1);
        test.add(1);
        assertThat(test.getMedian()).isEqualTo(1.0);
        test.remove(1);
        test.add(-1);
        assertThat(test.getMedian()).isEqualTo(-1.0);
        test.remove(-1);
        test.add(-1);
        assertThat(test.getMedian()).isEqualTo(-1.0);
    }
}
