package b;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by bohan on 4/27/17.
 */
public class StudentAttendanceRecordIITest {
    @Test
    public void test() {
        StudentAttendanceRecordII test = new StudentAttendanceRecordII();
        assertThat(test.checkRecord(100)).isEqualTo(985598218);
    }
}
