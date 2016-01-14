/**
 * 
 */
package com.dengpf.unitrun.core;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dengpf.unitrun.ClientTest;
import com.dengpf.unitrun.annotation.Test;
import com.dengpf.unitrun.model.FailedTest;
import com.dengpf.unitrun.model.MyTest;
import com.dengpf.unitrun.model.listener.IRunListener;
import com.dengpf.unitrun.model.listener.TestRunListener;
import com.dengpf.unitrun.utils.ReflectionUtils;

/**
 * @author kobe73er
 *
 */
public class Processor {
  private final static Logger LOGGER = LoggerFactory.getLogger(Processor.class);

  private List<FailedTest> failedTestList = new ArrayList<FailedTest>();
  private List<MyTest> normalTestList = new ArrayList<MyTest>();

  private List<IRunListener> listenerList = new ArrayList<IRunListener>();


  public static void main(String[] args) {
    Processor p = new Processor();
    p.handler(ClientTest.class);
  }

  private void handler(Class<?> clazz) {
    registerListneners(new TestRunListener());
    Method[] methods = clazz.getDeclaredMethods();
    for (Method item : methods) {
      if (!item.isAnnotationPresent(Test.class)) {
        continue;
      }
      MyTest mytestItem = wrapMethodToMyTest(item);
      if (!validateTestMethod(mytestItem)) {
        continue;
      }
      if (!filterDisabledMethod(mytestItem)) {
        continue;
      }
      recordTest(mytestItem);
      try {
        for (IRunListener runItem : listenerList) {
          runItem.runStart(mytestItem);
        }
        mytestItem.invoke(clazz.newInstance());
        for (IRunListener runItem : listenerList) {
          runItem.runFinish(mytestItem);
        }
      } catch (Exception ex) {
        for (IRunListener runItem : listenerList) {
          runItem.runAbort(mytestItem, ex);
        }
        addToFailedTestList(new FailedTest(mytestItem, ex));
      }
    }
  }

  public void registerListneners(IRunListener listener) {
    listenerList.add(listener);
  }

  private void recordTest(MyTest mytestItem) {
    normalTestList.add(mytestItem);
  }

  private void addToFailedTestList(FailedTest failedTest) {
    failedTestList.add(failedTest);
  }

  private boolean filterDisabledMethod(MyTest mytestItem) {
    return checkEnabled(mytestItem);
  }

  private boolean validateTestMethod(MyTest mytestItem) {
    return (ReflectionUtils.isPublic(mytestItem.getMethod()));
  }

  private boolean checkEnabled(MyTest mytestItem) {
    return mytestItem.isEnabled();
  }

  private MyTest wrapMethodToMyTest(Method method) {
    Test test = method.getAnnotation(Test.class);
    String id = test.id();
    String name = test.name();
    long timeout = test.timeout();
    boolean enabled = test.enabled();

    return new MyTest(method, name, id, enabled, timeout);
  }

}
