package com.dengpf.unitrun.model;

import java.lang.reflect.Method;

public class FailedTest extends FTest {

  public FailedTest(Method methodItem) {
    super(methodItem);
  }

  public FailedTest(FTest methodItem, Exception ex) {
    super(methodItem.getMethod());
    this.throwAble = ex;
  }
}
