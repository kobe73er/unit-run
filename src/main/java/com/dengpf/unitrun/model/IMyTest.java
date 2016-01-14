package com.dengpf.unitrun.model;

import java.lang.reflect.InvocationTargetException;

import com.dengpf.unitrun.annotation.Test;


public interface IMyTest {

  boolean isAnnotationPresent(Class<Test> class1);

  public void invoke(Object newInstance) throws IllegalAccessException, IllegalArgumentException,
      InvocationTargetException;

}
