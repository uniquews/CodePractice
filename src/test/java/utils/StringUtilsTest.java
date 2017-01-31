package utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bohan on 1/30/2017.
 *
 * @author Bohan Zheng
 */
public class StringUtilsTest {
  @Test
  public void test() {
    char[] strs = {0, 0, 'r', 'd'};
    assertEquals("2rd", StringUtils.charArrayToString(strs));
  }

  @Test
  public void test2() {
    char[] strs = {0, 0, 'r', 0};
    assertEquals("2r1", StringUtils.charArrayToString(strs));
  }

  @Test
  public void test3() {
    char[] strs = {0, 0, 0, 0};
    assertEquals("4", StringUtils.charArrayToString(strs));
  }
}
