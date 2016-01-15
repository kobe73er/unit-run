/**
 * 
 */
package com.dengpf.unitrun.core;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dengpf.unitrun.ClientTest;
import com.dengpf.unitrun.annotation.AfterClass;
import com.dengpf.unitrun.annotation.AfterEachMethod;
import com.dengpf.unitrun.annotation.BeforeClass;
import com.dengpf.unitrun.annotation.BeforeEachMethod;
import com.dengpf.unitrun.annotation.Test;
import com.dengpf.unitrun.model.FAfterClass;
import com.dengpf.unitrun.model.FAfterEachMethod;
import com.dengpf.unitrun.model.FBeforeClass;
import com.dengpf.unitrun.model.FBeforeEachMethod;
import com.dengpf.unitrun.model.FTest;
import com.dengpf.unitrun.model.FailedTest;
import com.dengpf.unitrun.model.FrameworkMember;
import com.dengpf.unitrun.model.FrameworkMethod;
import com.dengpf.unitrun.model.comparator.OrderComparator;
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
  private List<FTest> testList = new ArrayList<FTest>();

  private List<IRunListener> listenerList = new ArrayList<IRunListener>();

  private List<FBeforeEachMethod> beforeEachMethodList = new ArrayList<FBeforeEachMethod>();

  private List<FAfterEachMethod> afterEachMethodList = new ArrayList<FAfterEachMethod>();

  private List<FBeforeClass> beforeClassMethodList = new ArrayList<FBeforeClass>();

  private List<FAfterClass> afterClassMethodList = new ArrayList<FAfterClass>();

  private List<Class<?>> testClazzList = new ArrayList<Class<?>>();


  public static void main(String[] args) {
    Processor p = new Processor();
    p.init();
    p.handler(ClientTest.class);
  }


  private void handler(Class<ClientTest> class1) {
    init();

  }


  public void registerListener(IRunListener listener) {
    listenerList.add(listener);
  }

  private void init() {
    registerListener(new TestRunListener());
  }

  private void registerTestClass(Class [] clazzArr) {
    
  }


  private void preHandler(Class<ClientTest> clazz) {
    Method[] methods = clazz.getDeclaredMethods();
    for (Method method : methods) {
      if (method.isAnnotationPresent(Test.class)) {
        FTest fTest = wrapIntoFrameworkTest(method);
        testMethodFilter(fTest);
        testList.add(fTest);
      }
      if (method.isAnnotationPresent(BeforeEachMethod.class)) {
        FBeforeEachMethod fBeoreEachMethod = wrapIntoFrameworkBeforeEachMethod(method);
        beforeEachMethodFilter(fBeoreEachMethod);
        beforeEachMethodList.add(fBeoreEachMethod);
      }

      if (method.isAnnotationPresent(AfterEachMethod.class)) {
        FAfterEachMethod fAfterEachMethod = wrapIntoFrameWorkAfterEachMethod(method);
        afterEachmethodFilter(fAfterEachMethod);
        afterEachMethodList.add(fAfterEachMethod);
      }

      if (method.isAnnotationPresent(BeforeClass.class)) {
        FBeforeClass fBeforeClass = wrapIntoFrameworkBeforeClassMethod(method);
        beforeClassMethodFilter(method);
        beforeClassMethodList.add(fBeforeClass);
      }
      if (method.isAnnotationPresent(AfterClass.class)) {
        FAfterClass fAfterClass = wrapIntoFrameworkAfterClassMethod(method);
        afterClassMethodFilter(method);
        afterClassMethodList.add(fAfterClass);
      }

    }



  }


  private void afterClassMethodFilter(Method method) {
    // TODO Auto-generated method stub

  }


  private FAfterClass wrapIntoFrameworkAfterClassMethod(Method method) {
    // TODO Auto-generated method stub
    return null;
  }


  private void beforeClassMethodFilter(Method method) {
    // TODO Auto-generated method stub

  }


  private FBeforeClass wrapIntoFrameworkBeforeClassMethod(Method method) {
    // TODO Auto-generated method stub
    return null;
  }


  private void afterEachmethodFilter(FAfterEachMethod fAfterEachMethod) {
    // TODO Auto-generated method stub

  }


  private FAfterEachMethod wrapIntoFrameWorkAfterEachMethod(Method method) {
    // TODO Auto-generated method stub
    return null;
  }


  private void beforeEachMethodFilter(FBeforeEachMethod fBeoreEachMethod) {
    // TODO Auto-generated method stub

  }


  private FBeforeEachMethod wrapIntoFrameworkBeforeEachMethod(Method method) {
    // TODO Auto-generated method stub
    return null;
  }


  private void testMethodFilter(FTest fMethod) {
    ReflectionUtils.isPublic(fMethod.getMethod());

  }


  private FTest wrapIntoFrameworkTest(Method methodItem) {
    // TODO Auto-generated method stub
    return new FTest(methodItem);

  }



}
