package com.dengpf.unitrun.model;

import java.lang.reflect.Method;

import com.dengpf.unitrun.annotation.Test;


public class FTest extends FrameworkMethod {

  public FTest(Method methodItem) {
    Test test = methodItem.getAnnotation(Test.class);
    this.id = test.id();
    this.name = test.name();
    this.isEnabled = test.enabled();
    this.order = test.order();
    this.method = methodItem;
    this.timeout = test.timeout();
    
  }

}
