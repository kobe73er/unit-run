package com.dengpf.unitrun.model.listener;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dengpf.unitrun.model.FTest;
import com.dengpf.unitrun.model.FailedTest;
import com.dengpf.unitrun.model.IMyTest;

public class CommonRunListener implements IRunListener {
  long startTime;
  long endTime;
  long executionTime;

  private final static Logger LOGGER = LoggerFactory.getLogger(CommonRunListener.class);
  private PrintStream ps;


  public void runStart(IMyTest mytestItem) {
    startTime = System.currentTimeMillis();

  }

  public void runFinish(IMyTest mytestItem) {
    endTime = System.currentTimeMillis();
    executionTime = endTime - startTime;
    FTest test = (FTest) mytestItem;
    System.out.println("[test Id:" + test.getId() + "]" + "[test name:" + test.getName() + "]"
        + " execution time:" + executionTime + " ms");

  }

  public void runAbort(FTest mytestItem, Exception ex) {
    FailedTest failedTest = wrapToFailedTest(mytestItem, ex);
    recordFailedTest(failedTest);
  }

  private FailedTest wrapToFailedTest(FTest mytestItem, Exception ex) {
    return new FailedTest(mytestItem, ex);
  }

  private void recordFailedTest(FailedTest failedTest) {
    recordExecutionTime(failedTest);

    PrintStream pstream = getPrintStream();
    pstream.append("=========================================\n");
    pstream.append("[test failed] [test id:" + failedTest.getId() + "]" + "[test name:"
        + failedTest.getName() + "]\n");
    failedTest.getThrowAble().getCause().printStackTrace(pstream);

  }


  private void recordExecutionTime(FailedTest failedTest) {
    endTime = System.currentTimeMillis();
    executionTime = endTime - startTime;
    System.out.println("[test Id:" + failedTest.getId() + "]" + "[test name:"
        + failedTest.getName() + "]" + " execution time:" + executionTime + " ms");
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

}
