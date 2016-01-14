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
    Assert.assertEquals(1, 1);
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test(name = "testFailedOne name", id = "testFailedOne id", enabled = true)
  public void testFailedOne() {
    Assert.fail("fail test here");
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test(name = "testSucTwo name", id = "testSucTwo id")
  public void testSucTwo() {
    Assert.assertEquals(1, 1);
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  @Test(name = "testDiabled name", id = "testDiabled id", enabled = false)
  public void testDiabled() {
    Assert.debug("testDiabled here");
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test(name = "testFailedTwo name", id = "testFailedTwo id", enabled = true)
  public void testFailedTwo() {
    Assert.fail("testFailedTwo");
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test(name = "privateTest name", id = "privateTest id", enabled = true)
  private void privateTest() {
    Assert.debug("privateTest here");
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
