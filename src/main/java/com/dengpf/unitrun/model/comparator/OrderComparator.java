package com.dengpf.unitrun.model.comparator;

import java.util.Comparator;

import com.dengpf.unitrun.model.FBeforeEachMethod;

public class OrderComparator<FrameworkMethod> implements Comparator<FrameworkMethod> {

  public int compare(Object o1, Object o2) {
    FBeforeEachMethod itemOne = (FBeforeEachMethod) o1;
    FBeforeEachMethod itemTwo = (FBeforeEachMethod) o2;
    return itemOne.getOrder() - itemTwo.getOrder();
  }
}
