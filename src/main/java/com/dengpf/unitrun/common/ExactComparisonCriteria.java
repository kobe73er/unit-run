package com.dengpf.unitrun.common;


public class ExactComparisonCriteria extends ComparisonCriteria {
  @Override
  protected void assertElementsEqual(Object expected, Object actual) {
    Assert.assertEquals(expected, actual);
  }
}
