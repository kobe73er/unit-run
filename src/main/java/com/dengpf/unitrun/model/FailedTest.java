package com.dengpf.unitrun.model;



public class FailedTest extends MyTest {

  public FailedTest(MyTest mytestItem, Exception ex2) {
    super(mytestItem.getMethod(), mytestItem.getName(), mytestItem.getId(), mytestItem.isEnabled(),
        mytestItem.getTimeout());
    this.ex = ex2;
  }

  private Throwable ex;

  public Throwable getEx() {
    return ex;
  }

  public void setEx(Throwable ex) {
    this.ex = ex;
  }


}
