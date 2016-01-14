/**
 * 
 */
package com.dengpf.unitrun;

import com.dengpf.unitrun.annotation.*;
import com.dengpf.unitrun.common.Assert;

/**
 * @author kobe73er
 *
 */
public class ClientTest {

  /**
   * @param args
   */
  public static void main(String[] args) {

  }

  @Test
  public void testOne() {
    System.out.println("testOne is here");
    Assert.assertEquals(1, 1);
  }

  @Test(name = "first name", id = "first id", enabled = true)
  public void testFailedOne() {
    Assert.fail("fail test here");
  }

  @Test
  public void testSucTwo() {
    System.out.println("testSucTwo is here");
    Assert.assertEquals(1, 1);
  }

  @Test(name = "testDiabled name", id = "testDiabled id", enabled = false)
  public void testDiabled() {
    Assert.debug("testDiabled here");
  }

  @Test(name = "testFailedTwo name", id = "testFailedTwo id", enabled = true)
  public void testFailedTwo() {
    Assert.fail("testFailedTwo");
  }

  @Test(name = "privateTest name", id = "privateTest id", enabled = true)
  private void privateTest() {
    Assert.debug("privateTest here");
  }

}
