package com.dengpf.unitrun.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.dengpf.unitrun.annotation.Test;

public class MyTest implements IMyTest {

  private Method method;
  private String name;
  private String id;
  private boolean isEnabled;
  private long timeout;








  public MyTest(Method method, String name, String id, boolean isEnabled, long timeout) {
    super();
    this.method = method;
    this.name = name;
    this.id = id;
    this.isEnabled = isEnabled;
    this.timeout = timeout;
  }





  public boolean isEnabled() {
    return isEnabled;
  }

  public void setEnabled(boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  public long getTimeout() {
    return timeout;
  }

  public void setTimeout(long timeout) {
    this.timeout = timeout;
  }

  public Method getMethod() {
    return method;
  }

  public void setMethod(Method method) {
    this.method = method;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "MyTest [method=" + method + ", name=" + name + ", id=" + id + "]";
  }

  public boolean isAnnotationPresent(Class<?> targetClazz, Class<Test> TestClazz) {
    return targetClazz.isAnnotationPresent(TestClazz);
  }

  public void invoke(Object newInstance) throws IllegalAccessException, IllegalArgumentException,
      InvocationTargetException {
    method.invoke(newInstance);
  }

  public boolean isAnnotationPresent(Class<Test> targetAnnotation) {
    return method.isAnnotationPresent(targetAnnotation);
  }


}
