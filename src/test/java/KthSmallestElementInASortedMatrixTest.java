import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shuaiwang on 4/20/17.
 */
public class KthSmallestElementInASortedMatrixTest {
    @Test
    public void testFun1() {
        int[][] a = {{1,5,9},{10,11,13},{12,13,15}};
        int target = 5;
        KthSmallestElementInASortedMatrix test = new KthSmallestElementInASortedMatrix();
        Assert.assertEquals(2, test.findTargetPosition(a, target));
    }

    @Test
    public void testFun2() {
        int[][] a = {{1,5,9},{10,11,13},{12,13,15}};
        int target = 1;
        KthSmallestElementInASortedMatrix test = new KthSmallestElementInASortedMatrix();
        Assert.assertEquals(1, test.findTargetPosition(a, target));
    }

    @Test
    public void testFun3() {
        int[][] a = {{1,5,9},{10,11,13},{12,13,15}};
        int target = 9;
        KthSmallestElementInASortedMatrix test = new KthSmallestElementInASortedMatrix();
        Assert.assertEquals(3, test.findTargetPosition(a, target));
    }

    @Test
    public void testFun4() {
        int[][] a = {{1,5,9},{10,11,13},{12,13,15}};
        int target = 15;
        KthSmallestElementInASortedMatrix test = new KthSmallestElementInASortedMatrix();
        Assert.assertEquals(9, test.findTargetPosition(a, target));
    }

    @Test
    public void testFun5() {
        int[][] a = {{1,5,9},{10,11,13},{12,13,15}};
        int target = 8;
        KthSmallestElementInASortedMatrix test = new KthSmallestElementInASortedMatrix();
        Assert.assertEquals(13, test.kthSmallest(a, target));
    }

    @Test
    public void testFun6() {
        int[][] a = {{1,2} ,{1,3}};
        int target = 2;
        KthSmallestElementInASortedMatrix test = new KthSmallestElementInASortedMatrix();
        Assert.assertEquals(2, test.kthSmallest(a, target));
    }
}
