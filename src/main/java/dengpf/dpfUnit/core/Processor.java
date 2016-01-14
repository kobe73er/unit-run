/**
 * 
 */
package dengpf.dpfUnit.core;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dengpf.dpfUnit.ClientTest;
import dengpf.dpfUnit.annotation.Test;
import dengpf.dpfUnit.model.FailedTest;
import dengpf.dpfUnit.model.MyTest;
import dengpf.dpfUnit.utils.ReflectionUtils;

/**
 * @author kobe73er
 *
 */
public class Processor {
  // 定义一个全局的记录器，通过LoggerFactory获取
  private final static Logger LOGGER = LoggerFactory.getLogger(Processor.class);


  List<FailedTest> failedTestList = new ArrayList<FailedTest>();
  List<MyTest> normalTestList = new ArrayList<MyTest>();

  PrintStream ps;

  /**
   * @param args
   */
  public static void main(String[] args) {
    Processor p = new Processor();
    p.handler(ClientTest.class);
  }

  private void handler(Class<?> clazz) {
    Method[] methods = clazz.getDeclaredMethods();
    for (Method item : methods) {
      if (!item.isAnnotationPresent(Test.class)) {
        continue;
      }
      MyTest mytestItem = wrapMethodToMyTest(item);
      normalTestList.add(mytestItem);
      if (!validateTestMethod(mytestItem)) {
        continue;
      }
      if (!filterDisabledMethod(mytestItem)) {
        continue;
      }

      if (mytestItem.isAnnotationPresent(Test.class)) {
        try {
          mytestItem.invoke(clazz.newInstance());
        } catch (Exception ex) {
          FailedTest failedTest = wrapToFailedTest(mytestItem, ex);
          recordFailedTest(failedTest);
          LOGGER.error("[test failed] [test id:" + failedTest.getId() + "]" + "[test name:"
              + failedTest.getName() + "]", failedTest.getEx());
        }
      }
    }
  }

  private void recordFailedTest(FailedTest failedTest) {
    failedTestList.add(failedTest);
    PrintStream pstream = getPrintStream();
    pstream.append("=========================================\n");
    pstream.append("[test failed] [test id:" + failedTest.getId() + "]" + "[test name:"
        + failedTest.getName() + "]\n");
    failedTest.getEx().getCause().printStackTrace(pstream);
  }

  private PrintStream getPrintStream() {
    if (null == ps) {
      try {
        ps = new PrintStream(new FileOutputStream("FailedTest.txt"));
      } catch (FileNotFoundException e) {
        LOGGER.error("failed to find file ", e);
      }
    }
    return ps;

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

  private FailedTest wrapToFailedTest(MyTest mytestItem, Exception ex) {
    return new FailedTest(mytestItem, ex);

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
