/**
 * 
 */
package com.dengpf.unitrun.model.listener;

import com.dengpf.unitrun.model.IMyTest;
import com.dengpf.unitrun.model.MyTest;

/**
 * @author kobe73er
 *
 */
public interface IRunListener {
  public abstract void runStart(IMyTest mytestItem);

  public abstract void runFinish(IMyTest mytestItem);

  public abstract void runAbort(MyTest mytestItem, Exception ex);
}
